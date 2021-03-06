/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2005-2006,
 * @author JBoss Inc.
 */
/*
 * Copyright (C) 1998, 1999, 2000,
 *
 * Arjuna Solutions Limited,
 * Newcastle upon Tyne,
 * Tyne and Wear,
 * UK.
 *
 * $Id: RecoveryTest.java 2342 2006-03-30 13:06:17Z  $
 */

package com.hp.mwtests.ts.txoj.concurrencycontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.junit.Test;

import com.arjuna.ats.txoj.Lock;
import com.arjuna.ats.txoj.LockMode;
import com.arjuna.ats.txoj.LockStatus;

public class LockUnitTest
{
    @Test
    public void test () throws Exception
    {
        Lock lock = new Lock();
        
        lock = new Lock(LockMode.WRITE);
        
        assertTrue(lock.getAllOwners() != null);
        assertEquals(lock.getCurrentStatus(), LockStatus.LOCKFREE);
        
        assertFalse(lock.equals(new Object()));
        assertFalse(lock.equals((Object) new Lock()));
        assertTrue(lock.equals(lock));
        
        assertTrue(lock.toString() != null);
        
        assertEquals(lock.type(), "/StateManager/Lock");
        
        lock.print(new PrintWriter(new ByteArrayOutputStream()));
    }
}
