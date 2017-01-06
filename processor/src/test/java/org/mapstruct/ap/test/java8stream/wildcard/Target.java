/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.java8stream.wildcard;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Filip Hrisafov
 */
public class Target {

    private List<Plan> elements;

    private Stream<Plan> listElements;

    public List<Plan> getElements() {
        return elements;
    }

    public void setElements(List<Plan> elements) {
        this.elements = elements;
    }

    public Stream<Plan> getListElements() {
        return listElements;
    }

    public void setListElements(Stream<Plan> listElements) {
        this.listElements = listElements;
    }
}
