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

import com.github.stagirs.lingvo.model.Form;
import java.util.List;

/**
 *
 * @author Dmitriy Malakhov
 */
public class Text {
    public static class Markup{
        private String word; 
        private Form form; 
        private int pos; 
        private int length;
        private int indexFromBegin; 
        private int indexFromEnd;
        private List<Form> formCases; 

        public Form getForm() {
            return form;
        }

        public String getWord() {
            return word;
        }

        public void setForm(Form form) {
            this.form = form;
            for (Form formCase : formCases) {
                if(form.toString().equals(formCase.toString())){
                    return;
                }
            }
            this.formCases.add(form);
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getLength() {
            return length;
        }

        public int getPos() {
            return pos;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getIndexFromBegin() {
            return indexFromBegin;
        }

        public int getIndexFromEnd() {
            return indexFromEnd;
        }

        public void setIndexFromBegin(int indexFromBegin) {
            this.indexFromBegin = indexFromBegin;
        }

        public void setIndexFromEnd(int indexFromEnd) {
            this.indexFromEnd = indexFromEnd;
        }

        public List<Form> getFormCases() {
            return formCases;
        }

        public void setFormCases(List<Form> formCases) {
            this.formCases = formCases;
        }
    }
    
    private String hash;
    private String text;
    private List<Markup> markups;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Markup> getMarkups() {
        return markups;
    }

    public void setMarkups(List<Markup> markups) {
        this.markups = markups;
    }
}
