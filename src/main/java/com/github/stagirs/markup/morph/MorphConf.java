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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Dmitriy Malakhov
 */
public class MorphConf {
    
    private static List<Part> parts = new ArrayList<Part>();
    static {
        parts.add(
            new Part(new Item("Сущ.", Attr.NOUN), 
                new Section("Тип", 
                        new Item("Имя", Attr.anim, Attr.Name),
                        new Item("Фам.", Attr.anim, Attr.Surn),
                        new Item("Отч.", Attr.anim, Attr.Patr),
                        new Item("Одуш.", Attr.anim),
                        new Item("Геогр.", Attr.inan, Attr.Geox),
                        new Item("Организ.", Attr.inan, Attr.Orgn),
                        new Item("Бренд", Attr.inan, Attr.Trad),
                        new Item("Неодуш.", Attr.inan)
                ),
                new Section("Падеж", 
                        new Item("Им.", Attr.nomn), 
                        new Item("Род.", Attr.gent), 
                        new Item("Дат.", Attr.datv), 
                        new Item("Вин.", Attr.accs), 
                        new Item("Твор.", Attr.ablt), 
                        new Item("Предл.", Attr.loct), 
                        new Item("Зват.", Attr.voct)
                ), 
                new Section("Число", 
                        new Item("Ед.", Attr.sing), 
                        new Item("Мн.", Attr.plur)
                ), 
                new Section("Род", 
                        new Item("Муж.", Attr.masc), 
                        new Item("Жен.", Attr.femn), 
                        new Item("Ср.", Attr.neut), 
                        new Item("Общ.", Attr.ms_f),
                        new Item("Неизв.", Attr.GNdr)
                )
            )
        );
        
        parts.add(
            new Part(
                new Item("Инф.", Attr.INFN), 
                new Section("Переходность", 
                    new Item("Перех.", Attr.tran), 
                    new Item("Неперех.", Attr.intr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                ), 
                new Section("Безличное", new Item("Безл.", Attr.Impe))
            )
        );
        
        parts.add(
            new Part(
                new Item("Глаг. (Прош.)", Attr.VERB, Attr.indc, Attr.past), 
                new Section("Род/Число", 
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Общ.", Attr.Impe, Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),   
                new Section("Переходность", 
                    new Item("Перех.", Attr.tran), 
                    new Item("Неперех.", Attr.intr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                )
            )
        );
        
        parts.add(
            new Part(
                new Item("Глаг. (Повел.)", Attr.VERB, Attr.impr), 
                new Section("Род/Число", 
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Един.", Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),
                new Section("Совместность", 
                    new Item("Совм.", Attr.incl), 
                    new Item("Несовм.", Attr.excl)
                ),
                new Section("Переходность", 
                    new Item("Перех.", Attr.tran), 
                    new Item("Неперех.", Attr.intr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                )
            )
        );
        
        parts.add(
            new Part(
                new Item("Глаг.", Attr.VERB, Attr.indc), 
                new Section("Время", 
                    new Item("Наст.", Attr.pres), 
                    new Item("Будущ.", Attr.futr)
                ),
                new Section("Лицо", 
                    new Item("1 лицо.", Attr.N1per), 
                    new Item("2 лицо", Attr.N2per),
                    new Item("3 лицо", Attr.N3per),
                    new Item("Безличн.", Attr.Impe)
                ),
                new Section("Число", 
                    new Item("Един.", Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),    
                new Section("Переходность", 
                    new Item("Перех.", Attr.tran), 
                    new Item("Неперех.", Attr.intr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                )
            )
        );
       
        parts.add(
            new Part(
                new Item("Прил.(П.)", Attr.ADJF), 
                new Section("Род/Число", 
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),
                new Section("Падеж", 
                    new Item("Им.", Attr.nomn), 
                    new Item("Род.", Attr.gent), 
                    new Item("Дат.", Attr.datv), 
                    new Item("Вин. одуш.", Attr.accs, Attr.anim),
                    new Item("Вин. неодуш.", Attr.accs, Attr.inan),
                    new Item("Вин. одуш. и неодуш.", Attr.accs),
                    new Item("Твор.", Attr.ablt), 
                    new Item("Предл.", Attr.loct)
                ),     
                new Section("Притяжательное", new Item("Притяж.", Attr.Poss)), 
                new Section("Порядковое", new Item("Порядк.", Attr.Anum)), 
                new Section("Превосходное", new Item("Превосх.", Attr.Supr)), 
                new Section("Субстантивация", new Item("Субст.", Attr.Subx)), 
                new Section("Качественное", new Item("Кач.", Attr.Qual)), 
                new Section("Местоименное", new Item("Местоим.", Attr.Apro)), 
                new Section("Гео. название", new Item("Гео.", Attr.Geox))
            )
        );
        
        parts.add(
            new Part(
                new Item("Прил.(К.)", Attr.ADJS), 
                new Section("Род/Число", 
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),    
                new Section("Качественное", 
                    new Item("Кач.", Attr.Qual)
                ), 
                new Section("Местоименное", 
                    new Item("Местоим.", Attr.Apro)
                )
            )
        );
        
        parts.add(
            new Part(
                new Item("Нар.", Attr.ADVB), 
                new Section("Указательное", 
                    new Item("Указ.", Attr.Dmns)
                ), 
                new Section("Вопросительное", 
                    new Item("Вопр.", Attr.Ques)
                )
            )
        );
        
        parts.add(
            new Part(
                new Item("Прич.(П.)", Attr.PRTF), 
                new Section("Тип", 
                    new Item("Дей.", Attr.actv), 
                    new Item("Стр.", Attr.pssv)
                ),    
                new Section("Род/Число", 
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),
                new Section("Падеж", 
                    new Item("Им.", Attr.nomn), 
                    new Item("Род.", Attr.gent), 
                    new Item("Дат.", Attr.datv), 
                    new Item("Вин. одуш.", Attr.accs, Attr.anim),
                    new Item("Вин. неодуш.", Attr.accs, Attr.inan),
                    new Item("Вин. одуш. и неодуш.", Attr.accs),
                    new Item("Твор.", Attr.ablt), 
                    new Item("Предл.", Attr.loct)
                ),     
                new Section("Время", 
                    new Item("Наст.", Attr.pres), 
                    new Item("Прош.", Attr.past), 
                    new Item("Буд.", Attr.futr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                ), 
                new Section("Переходность", 
                    new Item("Перех.", Attr.tran), 
                    new Item("Неперех.", Attr.intr)
                ), 
                new Section("Субстантивация", new Item("Субст.", Attr.Subx))
            )
        );
        
        parts.add(
            new Part(
                new Item("Прич.(К.)", Attr.PRTS, Attr.pssv), 
                new Section("Род/Число", 
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Множ.", Attr.plur)
                ),    
                new Section("Время", 
                    new Item("Наст.", Attr.pres), 
                    new Item("Прош.", Attr.past), 
                    new Item("Буд.", Attr.futr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                )
            )
        );

        parts.add(
            new Part(
                new Item("ДееПрич.", Attr.GRND), 
                new Section("Время", 
                    new Item("Наст.", Attr.pres), 
                    new Item("Прош.", Attr.past), 
                    new Item("Буд.", Attr.futr)
                ), 
                new Section("Совершенность", 
                    new Item("Соверш.", Attr.perf), 
                    new Item("Несоверш.", Attr.impf)
                ), 
                new Section("Переходность", 
                    new Item("Перех.", Attr.tran), 
                    new Item("Неперех.", Attr.intr)
                ), 
                new Section("Несов. гл.", new Item("Несов. гл.", Attr.Fimp))    
            )
        );
        
        parts.add(
            new Part(
                new Item("Числ.", Attr.NUMR),    
                new Section("Падеж", 
                    new Item("Им.", Attr.nomn), 
                    new Item("Род.", Attr.gent), 
                    new Item("Дат.", Attr.datv), 
                    new Item("Вин. одуш.", Attr.accs, Attr.anim),
                    new Item("Вин. неодуш.", Attr.accs, Attr.inan),
                    new Item("Вин. одуш. и неодуш.", Attr.accs),
                    new Item("Твор.", Attr.ablt), 
                    new Item("Предл.", Attr.loct)
                ),     
                new Section("Муж.", new Item("Муж.", Attr.masc)), 
                new Section("Жен.", new Item("Жен.", Attr.femn)), 
                new Section("Ср.", new Item("Ср.", Attr.neut)) 
            )
        );
        
        parts.add(new Part(new Item("Вводн.", Attr.CONJ, Attr.Prnt)));
        parts.add(new Part(new Item("Комп.", Attr.COMP), new Section("Качественное", new Item("Кач.", Attr.Qual))));
        
        parts.add(
            new Part(
                new Item("М-им.", Attr.NPRO),   
                new Section("Тип", 
                    new Item("Личн. 1, Множ.", Attr.N1per, Attr.plur),
                    new Item("Личн. 1, Един.", Attr.N1per, Attr.sing),
                    new Item("Личн. 2, Множ.", Attr.N2per, Attr.plur),
                    new Item("Личн. 2, Един.", Attr.N2per, Attr.sing),
                    new Item("Личн. 3, Множ.", Attr.N3per, Attr.plur),
                    new Item("Личн. 3, Един., Муж.", Attr.N3per, Attr.sing, Attr.masc),
                    new Item("Личн. 3, Един., Жен.", Attr.N3per, Attr.sing, Attr.femn),
                    new Item("Личн. 3, Един., Ср.", Attr.N3per, Attr.sing, Attr.neut),    
                    new Item("Муж.", Attr.masc, Attr.sing), 
                    new Item("Жен.", Attr.femn, Attr.sing),
                    new Item("Ср.", Attr.neut, Attr.sing),
                    new Item("Един.", Attr.sing),    
                    new Item("Множ.", Attr.plur)
                ),
                new Section("Падеж", 
                    new Item("Им.", Attr.nomn), 
                    new Item("Род.", Attr.gent), 
                    new Item("Дат.", Attr.datv), 
                    new Item("Вин. одуш.", Attr.accs, Attr.anim),
                    new Item("Вин. неодуш.", Attr.accs, Attr.inan),
                    new Item("Вин. одуш. и неодуш.", Attr.accs),
                    new Item("Твор.", Attr.ablt), 
                    new Item("Предл.", Attr.loct)
                )     
            )
        );
        
        parts.add(new Part(new Item("П-в", Attr.PRED, Attr.pres)));
        parts.add(new Part(new Item("П-г", Attr.PREP)));
        parts.add(new Part(new Item("C-з", Attr.CONJ)));
        parts.add(new Part(new Item("Ч.", Attr.PRCL)));
        parts.add(new Part(new Item("Межд.", Attr.INTJ)));
        
        for (Part part : parts) {
            part.getSections().add(new Section("Разговорное", new Item("Разг.", Attr.Infr)));
            part.getSections().add(new Section("Жаргонное", new Item("Жарг.", Attr.Slng)));
            part.getSections().add(new Section("Устаревшее", new Item("Устар.", Attr.Arch)));
            part.getSections().add(new Section("Литературное", new Item("Литер.", Attr.Litr)));
            part.getSections().add(new Section("Аббревиатура", new Item("Сокр.", Attr.Abbr)));
        }
    }

    public static List<Part> getParts() {
        return parts;
    }
    
    public static class Item{
        String shortName;
        Attr[] attrs;

        public Item(String shortName, Attr ... attrs) {
            this.shortName = shortName;
            this.attrs = attrs;
        }

        public Attr[] getAttr() {
            return attrs;
        }

        public String getShortName() {
            return shortName;
        }
        
    }
    
    public static class Section{
        String name;
        Item[] items;

        public Section(String name, Item ... items) {
            this.name = name;
            this.items = items;
        }
        
        public Item[] getItems() {
            return items;
        }
    }
    
    public static class Part{
        Item item;
        List<Section> sections;

        public Part(Item item, Section ... sections) {
            this.item = item;
            this.sections = new ArrayList<>(Arrays.asList(sections));
        }

        public Item getItem() {
            return item;
        }

        public List<Section> getSections() {
            return sections;
        }
    }
}
