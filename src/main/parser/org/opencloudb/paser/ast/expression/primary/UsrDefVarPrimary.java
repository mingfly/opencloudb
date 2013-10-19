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
 * (created at 2011-1-21)
 */
package org.opencloudb.paser.ast.expression.primary;

import org.opencloudb.paser.visitor.SQLASTVisitor;

/**
 * @author mycat
 */
public class UsrDefVarPrimary extends VariableExpression {
    /** include starting '@', e.g. "@'mary''s'" */
    private final String varText;

    public UsrDefVarPrimary(String varText) {
        this.varText = varText;
    }

    public String getVarText() {
        return varText;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}