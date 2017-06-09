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

import java.io.Serializable;

import com.sesygroup.choreography.concreteparticipantbehavior.model.State;
import com.sesygroup.choreography.concreteparticipantbehavior.model.Transition;
import com.sesygroup.choreography.concreteparticipantbehavior.model.message.OutputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class AsynchronousSendActionTransition extends Transition implements Serializable {
   private static final long serialVersionUID = -5137545418464147425L;
   private OutputMessage outputMessage;

   public AsynchronousSendActionTransition() {
      super();
      outputMessage = null;
   }

   public AsynchronousSendActionTransition(final State sourceState, final State targetState,
         final OutputMessage outputMessage) {
      super(sourceState, targetState);
      this.outputMessage = outputMessage;
   }

   public OutputMessage getOutputMessage() {
      return outputMessage;
   }

   public void setOutputMessage(final OutputMessage outputMessage) {
      this.outputMessage = outputMessage;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((outputMessage == null)
            ? 0
            : outputMessage.hashCode());
      result = prime * result + ((super.sourceState == null)
            ? 0
            : super.sourceState.hashCode());
      result = prime * result + ((super.targetState == null)
            ? 0
            : super.targetState.hashCode());
      return result;
   }

   @Override
   public boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      AsynchronousSendActionTransition other = (AsynchronousSendActionTransition) obj;
      if (outputMessage == null) {
         if (other.outputMessage != null) {
            return false;
         }
      } else if (!outputMessage.equals(other.outputMessage)) {
         return false;
      }
      if (super.sourceState == null) {
         if (other.sourceState != null) {
            return false;
         }
      } else if (!super.sourceState.equals(other.sourceState)) {
         return false;
      }
      if (super.targetState == null) {
         if (other.targetState != null) {
            return false;
         }
      } else if (!super.targetState.equals(other.targetState)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "(" + sourceState + ", " + outputMessage + ", " + targetState + ", asynchronous)";
   }
}
