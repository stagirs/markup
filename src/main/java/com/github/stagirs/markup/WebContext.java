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
package com.github.stagirs.markup;

/**
 *
 * @author Dmitriy Malakhov
 */
public class WebContext {
    private static ThreadLocal<WebContext> local = new ThreadLocal<WebContext>();
    
    private String timestamp;
    private String url;
    private String login;
    
    public static void set(WebContext webContext){
        local.set(webContext);
    }
    
    public static WebContext get(){
        return local.get();
    }

    public String getLogin() {
        return login;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUrl() {
        return url;
    }
}
