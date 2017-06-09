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
import com.sesygroup.choreography.concreteparticipantbehavior.model.action.AsynchronousSendActionTransition;
import com.sesygroup.choreography.concreteparticipantbehavior.model.message.OutputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class AsynchronousSendActionTransitionTest {
   private static AsynchronousSendActionTransition mockedAsynchronousSendAction;
   private static AsynchronousSendActionTransition asynchronousSendAction;

   @BeforeClass
   public static void setUp() {
      State sourceState = new State("source");
      State targetState = new State("target");
      OutputMessage outputMessage = new OutputMessage("message");
      asynchronousSendAction = new AsynchronousSendActionTransition(sourceState, targetState, outputMessage);
      mockedAsynchronousSendAction = Mockito.mock(AsynchronousSendActionTransition.class);
      Mockito.when(mockedAsynchronousSendAction.getSourceState()).thenReturn(sourceState);
      Mockito.when(mockedAsynchronousSendAction.getTargetState()).thenReturn(targetState);
      Mockito.when(mockedAsynchronousSendAction.getOutputMessage()).thenReturn(outputMessage);
      Mockito.when(mockedAsynchronousSendAction.toString())
            .thenReturn("(source, message!, target, asynchronous)");
   }

   @Test
   public void testGetSourceState() {
      Assert.assertEquals(mockedAsynchronousSendAction.getSourceState(), asynchronousSendAction.getSourceState());
   }

   @Test
   public void testGetTargetState() {
      Assert.assertEquals(mockedAsynchronousSendAction.getTargetState(), asynchronousSendAction.getTargetState());
   }

   @Test
   public void testGetOutputMessage() {
      Assert.assertEquals(mockedAsynchronousSendAction.getOutputMessage(), asynchronousSendAction.getOutputMessage());
   }

   @Test
   public void testToString() {
      Assert.assertEquals(mockedAsynchronousSendAction.toString(), asynchronousSendAction.toString());
   }
}
