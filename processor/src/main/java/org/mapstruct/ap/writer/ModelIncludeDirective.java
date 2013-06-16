/**
 *  Copyright 2012-2013 Gunnar Morling (http://www.gunnarmorling.de/)
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
package org.mapstruct.ap.writer;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.mapstruct.ap.model.ModelElement;
import org.mapstruct.ap.writer.ModelWriter.DefaultModelElementWriterContext;

/**
 * A {@link TemplateDirectiveModel} which allows to recursively write a graph of
 * {@link ModelElement}s, with each element using its own template. Elements are
 * imported into the parent template by using this directive like so:
 * {@code <@includeModel object=myProperty/>}.
 *
 * @author Gunnar Morling
 */
public class ModelIncludeDirective implements TemplateDirectiveModel {

    private DefaultModelElementWriterContext context;

    public ModelIncludeDirective(DefaultModelElementWriterContext context) {
        this.context = context;
    }

    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
        throws TemplateException, IOException {

        Object wrappedObject = ( (BeanModel) params.get( "object" ) ).getWrappedObject();

        if ( !( wrappedObject instanceof ModelElement ) ) {
            throw new IllegalArgumentException( "Given object isn't a ModelElement:" + wrappedObject );
        }

        ModelElement modelElement = (ModelElement) wrappedObject;

        try {
            modelElement.write( context, env.getOut() );
        }
        catch ( TemplateException te ) {
            throw te;
        }
        catch ( IOException ioe ) {
            throw ioe;
        }
        catch ( RuntimeException re ) {
            throw re;
        }
        catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
}
