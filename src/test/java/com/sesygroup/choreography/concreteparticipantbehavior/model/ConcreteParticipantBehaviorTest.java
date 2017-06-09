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
package com.sesygroup.choreography.concreteparticipantbehavior.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;

import com.sesygroup.choreography.concreteparticipantbehavior.model.ConcreteParticipantBehavior;
import com.sesygroup.choreography.concreteparticipantbehavior.model.State;
import com.sesygroup.choreography.concreteparticipantbehavior.model.action.SynchronousSendActionTransition;
import com.sesygroup.choreography.concreteparticipantbehavior.model.message.OutputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class ConcreteParticipantBehaviorTest {
   private static ConcreteParticipantBehavior mockedConcreteParticipantBehavior;
   private static ConcreteParticipantBehavior concreteParticipantBehavior;

   @BeforeClass
   public static void setUp() {
      State initialState = new State("initialState");
      State targetState = new State("targetState");
      OutputMessage outputMessage = new OutputMessage("outputMessage");
      SynchronousSendActionTransition transition
            = new SynchronousSendActionTransition(initialState, targetState, outputMessage);
      concreteParticipantBehavior = new ConcreteParticipantBehavior();
      concreteParticipantBehavior.getStates().add(initialState);
      concreteParticipantBehavior.getStates().add(targetState);
      concreteParticipantBehavior.setInitialState(initialState);
      concreteParticipantBehavior.getMessages().add(outputMessage);
      concreteParticipantBehavior.getTransitions().add(transition);

      mockedConcreteParticipantBehavior = Mockito.mock(ConcreteParticipantBehavior.class);
      Mockito.when(mockedConcreteParticipantBehavior.getStates()).thenReturn(Sets.newSet(initialState, targetState));
      Mockito.when(mockedConcreteParticipantBehavior.getInitialState()).thenReturn(initialState);
      Mockito.when(mockedConcreteParticipantBehavior.getMessages()).thenReturn(Sets.newSet(outputMessage));
      Mockito.when(mockedConcreteParticipantBehavior.getTransitions()).thenReturn(Sets.newSet(transition));
      Mockito.when(mockedConcreteParticipantBehavior.validate()).thenReturn(true);
   }

   @Test
   public void testGetStates() {
      Assert.assertEquals(mockedConcreteParticipantBehavior.getStates(), concreteParticipantBehavior.getStates());
   }

   @Test
   public void testGetInitialState() {
      Assert.assertEquals(mockedConcreteParticipantBehavior.getInitialState(),
            concreteParticipantBehavior.getInitialState());
   }

   @Test
   public void testGetMessages() {
      Assert.assertEquals(mockedConcreteParticipantBehavior.getMessages(), concreteParticipantBehavior.getMessages());
   }

   @Test
   public void testGetTransitions() {
      Assert.assertEquals(mockedConcreteParticipantBehavior.getTransitions(),
            concreteParticipantBehavior.getTransitions());
   }

   @Test
   public void testValidate() {
      Assert.assertEquals(mockedConcreteParticipantBehavior.validate(), concreteParticipantBehavior.validate());
   }

   @Test()
   public void testNotValidate() {
      ConcreteParticipantBehavior concreteParticipantBehavior = new ConcreteParticipantBehavior();
      concreteParticipantBehavior.getTransitions().add(new SynchronousSendActionTransition(new State("initialState"),
            new State("targetState"), new OutputMessage("outputMessage")));
      Assert.assertFalse(concreteParticipantBehavior.validate());
   }

   @Test()
   public void testValidateEmptyConcreteParticipantBehavior() {
      Assert.assertTrue(new ConcreteParticipantBehavior().validate());

   }
}
