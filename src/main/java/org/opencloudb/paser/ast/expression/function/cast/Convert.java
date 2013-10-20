/*
 * Copyright 2012-2015 org.opencloudb.
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
/**
 * (created at 2011-1-23)
 */
package org.opencloudb.paser.ast.expression.function.cast;

import java.util.List;

import org.opencloudb.paser.ast.expression.Expression;
import org.opencloudb.paser.ast.expression.function.FunctionExpression;
import org.opencloudb.paser.visitor.SQLASTVisitor;

/**
 * @author mycat
 */
public class Convert extends FunctionExpression {
    /**
     * Either {@link transcodeName} or {@link typeName} is null
     */
    private final String transcodeName;

    public Convert(Expression arg, String transcodeName) {
        super("CONVERT", wrapList(arg));
        if (null == transcodeName) {
            throw new IllegalArgumentException("transcodeName is null");
        }
        this.transcodeName = transcodeName;
    }

    public String getTranscodeName() {
        return transcodeName;
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        throw new UnsupportedOperationException("function of char has special arguments");
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}