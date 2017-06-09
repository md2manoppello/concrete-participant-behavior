/*
 * Copyright 2017 Software Engineering and Synthesis Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sesygroup.choreography.concreteparticipantbehavior.model.action;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.sesygroup.choreography.concreteparticipantbehavior.model.State;
import com.sesygroup.choreography.concreteparticipantbehavior.model.action.SynchronousReceiveActionTransition;
import com.sesygroup.choreography.concreteparticipantbehavior.model.message.InputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class SynchronousReceiveActionTransitionTest {
   private static SynchronousReceiveActionTransition mockedSynchronousReceiveAction;
   private static SynchronousReceiveActionTransition synchronousReceiveAction;

   @BeforeClass
   public static void setUp() {
      State sourceState = new State("source");
      State targetState = new State("target");
      InputMessage inputMessage = new InputMessage("message");
      synchronousReceiveAction = new SynchronousReceiveActionTransition(sourceState, targetState, inputMessage);
      mockedSynchronousReceiveAction = Mockito.mock(SynchronousReceiveActionTransition.class);
      Mockito.when(mockedSynchronousReceiveAction.getSourceState()).thenReturn(sourceState);
      Mockito.when(mockedSynchronousReceiveAction.getTargetState()).thenReturn(targetState);
      Mockito.when(mockedSynchronousReceiveAction.getInputMessage()).thenReturn(inputMessage);
      Mockito.when(mockedSynchronousReceiveAction.toString())
            .thenReturn("(source, message?, target, synchronous)");
   }

   @Test
   public void testGetSourceState() {
      Assert.assertEquals(mockedSynchronousReceiveAction.getSourceState(), synchronousReceiveAction.getSourceState());
   }

   @Test
   public void testGetTargetState() {
      Assert.assertEquals(mockedSynchronousReceiveAction.getTargetState(), synchronousReceiveAction.getTargetState());
   }

   @Test
   public void testGetInputMessage() {
      Assert.assertEquals(mockedSynchronousReceiveAction.getInputMessage(), synchronousReceiveAction.getInputMessage());
   }

   @Test
   public void testToString() {
      Assert.assertEquals(mockedSynchronousReceiveAction.toString(), synchronousReceiveAction.toString());
   }
}
