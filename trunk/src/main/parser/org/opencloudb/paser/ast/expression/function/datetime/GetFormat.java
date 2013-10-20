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
package org.opencloudb.paser.ast.expression.function.datetime;

import java.util.List;

import org.opencloudb.paser.ast.expression.Expression;
import org.opencloudb.paser.ast.expression.function.FunctionExpression;
import org.opencloudb.paser.visitor.SQLASTVisitor;

/**
 * @author mycat
 */
public class GetFormat extends FunctionExpression {
    public static enum FormatType {
        DATE,
        TIME,
        DATETIME
    }

    private FormatType formatType;

    public GetFormat(FormatType type, Expression format) {
        super("GET_FORMAT", wrapList(format));
        this.formatType = type;
    }

    public FormatType getFormatType() {
        return formatType;
    }

    public Expression getFormat() {
        return arguments.get(0);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        throw new UnsupportedOperationException("function of GetFormat has special arguments");
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

}