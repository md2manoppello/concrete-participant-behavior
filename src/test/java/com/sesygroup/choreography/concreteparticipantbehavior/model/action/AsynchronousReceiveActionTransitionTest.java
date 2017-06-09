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
import com.sesygroup.choreography.concreteparticipantbehavior.model.action.AsynchronousReceiveActionTransition;
import com.sesygroup.choreography.concreteparticipantbehavior.model.message.InputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class AsynchronousReceiveActionTransitionTest {
   private static AsynchronousReceiveActionTransition mockedAsynchronousReceiveAction;
   private static AsynchronousReceiveActionTransition asynchronousReceiveAction;

   @BeforeClass
   public static void setUp() {
      State sourceState = new State("source");
      State targetState = new State("target");
      InputMessage inputMessage = new InputMessage("message");
      asynchronousReceiveAction = new AsynchronousReceiveActionTransition(sourceState, targetState, inputMessage);
      mockedAsynchronousReceiveAction = Mockito.mock(AsynchronousReceiveActionTransition.class);
      Mockito.when(mockedAsynchronousReceiveAction.getSourceState()).thenReturn(sourceState);
      Mockito.when(mockedAsynchronousReceiveAction.getTargetState()).thenReturn(targetState);
      Mockito.when(mockedAsynchronousReceiveAction.getInputMessage()).thenReturn(inputMessage);
      Mockito.when(mockedAsynchronousReceiveAction.toString()).thenReturn("(source, message?, target, asynchronous)");
   }

   @Test
   public void testGetSourceState() {
      Assert.assertEquals(mockedAsynchronousReceiveAction.getSourceState(), asynchronousReceiveAction.getSourceState());
   }

   @Test
   public void testGetTargetState() {
      Assert.assertEquals(mockedAsynchronousReceiveAction.getTargetState(), asynchronousReceiveAction.getTargetState());
   }

   @Test
   public void testGetInputMessage() {
      Assert.assertEquals(mockedAsynchronousReceiveAction.getInputMessage(),
            asynchronousReceiveAction.getInputMessage());
   }

   @Test
   public void testToString() {
      Assert.assertEquals(mockedAsynchronousReceiveAction.toString(), asynchronousReceiveAction.toString());
   }
}
