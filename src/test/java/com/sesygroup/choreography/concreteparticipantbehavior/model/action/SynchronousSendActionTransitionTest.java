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
import com.sesygroup.choreography.concreteparticipantbehavior.model.action.SynchronousSendActionTransition;
import com.sesygroup.choreography.concreteparticipantbehavior.model.message.OutputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class SynchronousSendActionTransitionTest {
   private static SynchronousSendActionTransition mockedSynchronousSendAction;
   private static SynchronousSendActionTransition synchronousSendAction;

   @BeforeClass
   public static void setUp() {
      State sourceState = new State("source");
      State targetState = new State("target");
      OutputMessage outputMessage = new OutputMessage("message");
      synchronousSendAction = new SynchronousSendActionTransition(sourceState, targetState, outputMessage);
      mockedSynchronousSendAction = Mockito.mock(SynchronousSendActionTransition.class);
      Mockito.when(mockedSynchronousSendAction.getSourceState()).thenReturn(sourceState);
      Mockito.when(mockedSynchronousSendAction.getTargetState()).thenReturn(targetState);
      Mockito.when(mockedSynchronousSendAction.getOutputMessage()).thenReturn(outputMessage);
      Mockito.when(mockedSynchronousSendAction.toString()).thenReturn("(source, message!, target, synchronous)");
   }

   @Test
   public void testGetSourceState() {
      Assert.assertEquals(mockedSynchronousSendAction.getSourceState(), synchronousSendAction.getSourceState());
   }

   @Test
   public void testGetTargetState() {
      Assert.assertEquals(mockedSynchronousSendAction.getTargetState(), synchronousSendAction.getTargetState());
   }

   @Test
   public void testGetOutputMessage() {
      Assert.assertEquals(mockedSynchronousSendAction.getOutputMessage(), synchronousSendAction.getOutputMessage());
   }

   @Test
   public void testToString() {
      Assert.assertEquals(mockedSynchronousSendAction.toString(), synchronousSendAction.toString());
   }
}
