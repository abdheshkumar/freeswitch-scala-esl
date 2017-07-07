/*
 * Copyright 2017 Call Handling Services Ltd.
 * <http://www.callhandling.co.uk>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ngage.domain

object HangupCauses {

  sealed trait HangupCause {
    /**
      * Standard telephony disconnect cause codes for ISDN
      */
    val q850Code: Int
  }

  /**
    * This is usually given by the router when none of the other codes apply.
    * This cause usually occurs in the same type of situations as cause 1, cause 88, and cause 100.
    */
  case object Unspecified extends HangupCause {
    val q850Code = 0
  }

  /**
    * This cause indicates that the called party cannot be reached because, although the called party number is in a valid format, it is not currently allocated (assigned).
    */
  case object UnallocatedNumber extends HangupCause {
    val q850Code = 1
  }

  /**
    * This cause indicates that the equipment sending this cause has received a request to route the call through a particular transit network, which it does not recognize.
    * The equipment sending this cause does not recognize the transit network either because the transit network does not exist or because that particular transit network, while it does exist, does not serve the equipment which is sending this cause.
    */
  case object NoRouteTransitNet extends HangupCause {
    val q850Code = 2
  }

  /**
    * This cause indicates that the called party cannot be reached because the network through which the call has been routed does not serve the destination desired.
    * This cause is supported on a network dependent basis.
    */
  case object NoRouteDestination extends HangupCause {
    val q850Code = 3
  }

  /**
    * This cause indicates that the channel most recently identified is not acceptable to the sending entity for use in this call.
    */
  case object ChannelUnacceptable extends HangupCause {
    val q850Code = 6
  }

  /**
    * This cause indicates that the user has been awarded the incoming call, and that the incoming call is being connected to a channel already established to that user for similar calls (e.g. packet-mode x.25 virtual calls).
    */
  case object CallAwardedDelivered extends HangupCause {
    val q850Code = 7
  }

  /**
    * This cause indicates that the call is being cleared because one of the users involved in the call has requested that the call be cleared. Under normal situations, the source of this cause is not the network.
    */
  case object NormalClearing extends HangupCause {
    val q850Code = 16
  }

  /**
    * This cause is used to indicate that the called party is unable to accept another call because the user busy condition has been encountered.
    * This cause value may be generated by the called user or by the network. In the case of user determined user busy it is noted that the user equipment is compatible with the call.
    */
  case object UserBusy extends HangupCause {
    val q850Code = 17
  }

  /**
    * This cause is used when a called party does not respond to a call establishment message with either an alerting or connect indication within the prescribed period of time allocated.
    */
  case object NoUserResponse extends HangupCause {
    val q850Code = 18
  }

  /**
    * This cause is used when the called party has been alerted but does not respond with a connect indication within a prescribed period of time.
    * Note - This cause is not necessarily generated by Q.931 procedures but may be generated by internal network timers.
    */
  case object NoAnswer extends HangupCause {
    val q850Code = 19
  }

  /**
    * This cause value is used when a mobile station has logged off, radio contact is not obtained with a mobile station or if a personal telecommunication user is temporarily not addressable at any user-network interface.
    * Sofia SIP will normally raise USER_NOT_REGISTERED in such situations.
    */
  case object SubscriberAbsent extends HangupCause {
    val q850Code = 20
  }

  /**
    * This cause indicates that the equipment sending this cause does not wish to accept this call, although it could have accepted the call because the equipment sending this cause is neither busy nor incompatible.
    * The network may also generate this cause, indicating that the call was cleared due to a supplementary service constraint.
    * The diagnostic field may contain additional information about the supplementary service and reason for rejection.
    */
  case object CallRejected extends HangupCause {
    val q850Code = 21
  }

  /**
    * This cause is returned to a calling party when the called party number indicated by the calling party is no longer assigned, The new called party number may optionally be included in the diagnostic field.
    * If a network does not support this cause, cause no: 1, unallocated (unassigned) number shall be used.
    */
  case object NumberChanged extends HangupCause {
    val q850Code = 22
  }

  /**
    * This cause is used by a general ISUP protocol mechanism that can be invoked by an exchange that decides that the call should be set-up to a different called number.
    * Such an exchange can invoke a redirection mechanism, by use of this cause value, to request a preceding exchange involved in the call to route the call to the new number.
    */
  case object RedirectionToNewDestination extends HangupCause {
    val q850Code = 23
  }

  /**
    * This cause indicates that the destination indicated by the user cannot be reached, because an intermediate exchange has released the call due to reaching a limit in executing the hop counter procedure.
    * This cause is generated by an intermediate node, which when decrementing the hop counter value, gives the result 0.
    */
  case object ExchangeRoutingError extends HangupCause {
    val q850Code = 25
  }

  /**
    * This cause indicates that the destination indicated by the user cannot be reached because the interface to the destination is not functioning correctly.
    * The term "not functioning correctly" indicates that a signal message was unable to be delivered to the remote party;
    * e.g. a physical layer or data link layer failure at the remote party, or user equipment off-line.
    */
  case object DestinationOutOfOrder extends HangupCause {
    val q850Code = 27
  }

  /**
    * This cause indicates that the called party cannot be reached because the called party number is not in a valid format or is not complete.
    */
  case object InvalidNumberFormat extends HangupCause {
    val q850Code = 28
  }

  /**
    * This cause is returned when a supplementary service requested by the user cannot be provide by the network.
    */
  case object FacilityRejected extends HangupCause {
    val q850Code = 29
  }

  /**
    * This cause is included in the STATUS message when the reason for generating the STATUS message was the prior receipt of a STATUS INQUIRY.
    */
  case object ResponseToStatusEnquiry extends HangupCause {
    val q850Code = 30
  }

  /**
    * This cause is used to report a normal event only when no other cause in the normal class applies.
    */
  case object NormalUnspecified extends HangupCause {
    val q850Code = 31
  }

  /**
    * This cause indicates that there is no appropriate circuit/channel presently available to handle the call.
    */
  case object NormalCircuitCongestion extends HangupCause {
    val q850Code = 34
  }

  /**
    * This cause indicates that the network is not functioning correctly and that the condition is likely to last a relatively long period of time
    * e.g. immediately re-attempting the call is not likely to be successful.
    */
  case object NetworkOutOfOrder extends HangupCause {
    val q850Code = 38
  }

  /**
    * This cause indicates that the network is not functioning correctly and that the condition is not likely to last a long period of time;
    * e.g. the user may wish to try another call attempt almost immediately.
    */
  case object NormalTemporaryFailure extends HangupCause {
    val q850Code = 41
  }

  /**
    * This cause indicates that the switching equipment generating this cause is experiencing a period of high traffic.
    */
  case object SwitchCongestion extends HangupCause {
    val q850Code = 42
  }


  //ToDO : Add remaining hangup causes https://freeswitch.org/confluence/display/FREESWITCH/Hangup+Cause+Code+Table


  val causes = Map("UNSPECIFIED" -> Unspecified, "UNALLOCATED_NUMBER" -> UnallocatedNumber, "NO_ROUTE_TRANSIT_NET" -> NoRouteTransitNet,
    "NO_ROUTE_DESTINATION" -> NoRouteDestination, "CHANNEL_UNACCEPTABLE" -> ChannelUnacceptable, "CALL_AWARDED_DELIVERED" -> CallAwardedDelivered,
    "NORMAL_CLEARING" -> NormalClearing, "USER_BUSY" -> UserBusy, "NO_USER_RESPONSE" -> NoUserResponse, "NO_ANSWER" -> NoAnswer,
    "SUBSCRIBER_ABSENT" -> SubscriberAbsent, "CALL_REJECTED" -> CallRejected, "NUMBER_CHANGED" -> NumberChanged,
    "REDIRECTION_TO_NEW_DESTINATION" -> RedirectionToNewDestination, "EXCHANGE_ROUTING_ERROR" -> ExchangeRoutingError,
    "DESTINATION_OUT_OF_ORDER" -> DestinationOutOfOrder, "INVALID_NUMBER_FORMAT" -> InvalidNumberFormat, "FACILITY_REJECTED" -> FacilityRejected,
    "RESPONSE_TO_STATUS_ENQUIRY" -> ResponseToStatusEnquiry, "NORMAL_UNSPECIFIED" -> NormalUnspecified, "NORMAL_CIRCUIT_CONGESTION" -> NormalCircuitCongestion,
    "NETWORK_OUT_OF_ORDER" -> NetworkOutOfOrder, "NORMAL_TEMPORARY_FAILURE" -> NormalTemporaryFailure, "SWITCH_CONGESTION" -> SwitchCongestion)
}
