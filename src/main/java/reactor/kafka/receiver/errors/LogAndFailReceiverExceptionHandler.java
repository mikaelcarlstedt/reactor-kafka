/*
 * Copyright (c) 2016-2020 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.kafka.receiver.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Receiver exception handler that logs an exception and then fails.
 */
public class LogAndFailReceiverExceptionHandler implements ReceiverExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(LogAndFailReceiverExceptionHandler.class);

    @Override
    public ReceiverExceptionHandlerResponse handle(final Exception exception) {
        log.error("Receiver exception caught: {}",
                  exception.getLocalizedMessage(),
                  exception);

        return ReceiverExceptionHandlerResponse.FAIL;
    }

}
