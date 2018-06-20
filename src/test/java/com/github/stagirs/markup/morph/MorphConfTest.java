/*
 * Copyright 2018 Dmitriy Malakhov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.stagirs.markup.morph;

import com.github.stagirs.markup.morph.MorphConf;
import com.github.stagirs.lingvo.model.Attr;
import com.github.stagirs.lingvo.model.Form;
import com.github.stagirs.lingvo.morph.MorphIterator;
import com.github.stagirs.lingvo.morph.model.Morph;
import com.github.stagirs.markup.morph.MorphConf.Part;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Dmitriy Malakhov
 */
public class MorphConfTest {
    @Test
    public void main() {
        MorphIterator iterator = new MorphIterator();
        int count = 0;
        while(iterator.hasNext()){
            Morph morph = iterator.next();
            for (int i = 0; i < morph.getNormCount(); i++) {
                for (Form form : morph.getRawForms(i)) {
                    if(form.getAttrs().contains(Attr.Dist) || form.getAttrs().contains(Attr.Erro)){
                        continue;
                    }
                    check(form);
                    count++;
                    if(count % 100000 == 0){
                        System.out.println(count);
                    }
                }
            }
        }    
    }
    
    private static void check(Form form){
        Part maxPart = null;
        for (MorphConf.Part part : MorphConf.getParts()) {
            if(!form.getAttrs().containsAll(Arrays.asList(part.item.attrs))){
                continue;
            }
            if(maxPart == null || maxPart.item.attrs.length < part.item.attrs.length){
                maxPart = part;
            }
        }
        if(maxPart == null){
            throw new RuntimeException();
        }
        check(form, maxPart);
    }
    
    private static void check(Form form, MorphConf.Part part){
        Set<Attr> attrs = new HashSet<Attr>(form.getAttrs());
        attrs.removeAll(Arrays.asList(part.item.attrs));
        for (MorphConf.Section section : part.sections) {
            if(section.items.length == 1){
                attrs.removeAll(Arrays.asList(section.items[0].attrs));
            }else{
                attrs.removeAll(Arrays.asList(check(form, section).attrs));
            }
        }
        if(!attrs.isEmpty()){
            throw new RuntimeException();
        }
    }
    
    private static MorphConf.Item check(Form form, MorphConf.Section section){
        for(MorphConf.Item item : section.items){
            if(!form.getAttrs().containsAll(Arrays.asList(item.getAttr()))){
                continue;
            }
            return item;
        }
        throw new RuntimeException();
    }
}
