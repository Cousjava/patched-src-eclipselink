/*******************************************************************************
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.jpql;

/**
 * This <code>DerivedDeclaration</code> represents an identification variable declaration that was
 * declared in the <code><b>FROM</b></code> clause of a <code><b>SELECT</b></code> subquery. The
 * "root" object is not an entity name but a derived path expression.
 *
 * @see org.eclipse.persistence.jpa.jpql.parser.IdentificationVariableDeclaration IdentificationVariableDeclaration
 *
 * @version 2.5
 * @since 2.5
 * @author Pascal Filion
 */
public class DerivedDeclaration extends AbstractRangeDeclaration {

	/**
	 * Creates a new <code>DerivedDeclaration</code>.
	 */
	public DerivedDeclaration() {
		super();
	}

	/**
	 * If {@link #isDerived()} is <code>true</code>, then returns the identification variable used
	 * in the derived path expression that is defined in the superquery, otherwise returns an
	 * empty string.
	 *
	 * @return The identification variable from the superquery if the root path is a derived path
	 * expression
	 */
	public String getSuperqueryVariableName() {
		int index = rootPath.indexOf('.');
		return (index > -1) ? rootPath.substring(0, index) : ExpressionTools.EMPTY_STRING;
	}

	/**
	 * {@inheritDoc}
	 */
	public Type getType() {
		return Type.DERIVED;
	}
}