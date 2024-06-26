/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.consensus.qbft.pki;

import org.hyperledger.besu.consensus.common.bft.BftBlockHeaderFunctions;
import org.hyperledger.besu.ethereum.core.BlockHeaderFunctions;

/** The Pki qbft block header functions. */
public class PkiQbftBlockHeaderFunctions {
  /** Default constructor */
  private PkiQbftBlockHeaderFunctions() {}

  /**
   * Create block header functions for cms signature.
   *
   * @param bftExtraDataCodec the bft extra data codec
   * @return the block header functions
   */
  public static BlockHeaderFunctions forCmsSignature(
      final PkiQbftExtraDataCodec bftExtraDataCodec) {
    return new BftBlockHeaderFunctions(
        h -> new PkiQbftBlockHashing(bftExtraDataCodec).calculateHashOfBftBlockForCmsSignature(h),
        bftExtraDataCodec);
  }
}
