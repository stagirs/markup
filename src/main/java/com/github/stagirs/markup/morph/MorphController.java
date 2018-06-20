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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.stagirs.lingvo.model.Form;
import com.github.stagirs.markup.morph.MorphConf.Part;
import com.github.stagirs.markup.morph.Text.Markup;
import com.github.stagirs.markup.morph.data.TextStore;
import com.github.stagirs.markup.morph.data.user.MorphStore;
import com.github.stagirs.markup.morph.data.user.TextEditStore;
import java.net.URLEncoder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dmitriy Malakhov
 */
@Controller("/")
public class MorphController {
    @Autowired
    TextStore textStore;
    @Autowired
    TextEditStore textEditStore;
    @Autowired
    MorphStore morphStore;
    
    @RequestMapping(value = "/morphConf", method = RequestMethod.GET)
    public @ResponseBody List<Part> morphConf() throws Exception {
        long hash = textStore.getNextTextHash();
        String text = textEditStore.getLastEdit(hash);
        if(text == null){
            text = textStore.getText(hash);
        }
        return MorphConf.getParts();
    }
    
    @RequestMapping(value = "/morphNextText", method = RequestMethod.GET)
    public @ResponseBody Text morphNextText() throws Exception {
        long hash = textStore.getNextTextHash();
        String text = textEditStore.getLastEdit(hash);
        if(text == null){
            text = textStore.getText(hash);
        }
        return parse(hash, text);
    }
    
    @RequestMapping(value = "/editText", method = RequestMethod.POST)
    public @ResponseBody Text editText(
            @RequestParam(name = "hash") long hash,
            @RequestParam(name = "text") String text
        ) throws Exception {
        textEditStore.setEdit(hash, text);
        return parse(hash, text);
    }   
    
    @RequestMapping(value = "/addMorph", method = RequestMethod.POST)
    public @ResponseBody String addMorph(
            @RequestParam(name = "hash") long hash,
            @RequestParam(name = "markup") String markupText
        ) throws Exception {
        Markup markup = new ObjectMapper().readValue(URLEncoder.encode(markupText, "utf-8"), Markup.class);
        morphStore.addMorph(hash, markup.getWord(), markup.getForm(), markup.getIndexFromBegin(), markup.getIndexFromEnd());
        return "'OK'";
    }
    
    @RequestMapping(value = "/caseMorph", method = RequestMethod.POST)
    public @ResponseBody String caseMorph(
            @RequestParam(name = "hash") long hash,
            @RequestParam(name = "markup") String markupText
        ) throws Exception {
        Markup markup = new ObjectMapper().readValue(URLEncoder.encode(markupText, "utf-8"), Markup.class);
        morphStore.caseMorph(hash, markup.getWord(), markup.getForm(), markup.getIndexFromBegin(), markup.getIndexFromEnd());
        return "'OK'";
    }
    
    private Text parse(long hash, String line){
        Text text = TextProcessor.parse(hash, line);
        for(Markup markup : text.getMarkups()){
            Form form = morphStore.getForm(hash, markup.getWord(), markup.getIndexFromBegin(), markup.getIndexFromEnd());
            if(form != null){
                markup.setForm(form);
            }
        }
        return text;
    }
}
