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


import com.github.stagirs.lingvo.model.Attr;
import com.github.stagirs.lingvo.model.Form;
import com.github.stagirs.lingvo.morph.MorphIterator;
import com.github.stagirs.lingvo.morph.model.Morph;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.procedure.TObjectIntProcedure;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author Dmitriy Malakhov
 */
public class AttrStatTest {
    /**
     * Распределение атрибутов по частям речи
     */
    @Test
    public void test(){
        MorphIterator iterator = new MorphIterator();
        Map<Attr, TObjectIntHashMap<Attr>> stat = new HashMap<Attr, TObjectIntHashMap<Attr>>();
        while(iterator.hasNext()){
            Morph morph = iterator.next();
            for (int i = 0; i < morph.getNormCount(); i++) {
                for(Form form : morph.getRawForms(i)){
                    for (int j = 1; j < form.getAttrs().size(); j++) {
                        Attr attr = form.getAttrs().get(j);
                        if(!stat.containsKey(attr)){
                            stat.put(attr, new TObjectIntHashMap<Attr>());
                        }
                        stat.get(attr).adjustOrPutValue(form.getAttrs().get(0), 1, 1);
                    }
                }
            }
        }
        for (Map.Entry<Attr, TObjectIntHashMap<Attr>> entrySet : stat.entrySet()) {
            final StringBuilder sb = new StringBuilder();
            entrySet.getValue().forEachEntry(new TObjectIntProcedure<Attr>() {
                @Override
                public boolean execute(Attr k, int i) {
                    sb.append(" ").append(k).append(" ").append(i);
                    return true;
                }
            });
            System.out.println(entrySet.getKey() + sb.toString());
        }
    }
    
    /**
     * Пример теста для выявляения встречаемости атрибутов с частями речи
     */
    @Test
    public void test2(){
        MorphIterator iterator = new MorphIterator();
        while(iterator.hasNext()){
            Morph morph = iterator.next();
            String word = morph.getRaw();
            for (int i = 0; i < morph.getNormCount(); i++) {
                for(Form form : morph.getRawForms(i)){
                    if(form.getAttrs().contains(Attr.ADJF) && form.getAttrs().contains(Attr.masc) && form.getAttrs().contains(Attr.accs) && !form.getAttrs().contains(Attr.anim) && !form.getAttrs().contains(Attr.inan)){
                        System.out.println(word + " " + form + " " + morph.getNorm(i) + " " + morph.getNormForms(i)[0]);
                    }
                }
            }
        }
    }
}
