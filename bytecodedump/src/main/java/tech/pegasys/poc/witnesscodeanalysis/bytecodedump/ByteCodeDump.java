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
package tech.pegasys.poc.witnesscodeanalysis.bytecodedump;

import org.apache.tuweni.bytes.Bytes;
import tech.pegasys.poc.witnesscodeanalysis.CodeAnalysisBase;


/**
 * Prints out the program counter offset, opcodes and parameter. For example:
 *
 * PC: 0x5d5d, opcode: PUSH1 0x20
 * PC: 0x5d5f, opcode: ADD
 * PC: 0x5d60, opcode: PUSH1 0x00
 * PC: 0x5d62, opcode: DUP2
 * PC: 0x5d63, opcode: MSTORE
 * PC: 0x5d64, opcode: PUSH1 0x20
 * PC: 0x5d66, opcode: ADD
 * PC: 0x5d67, opcode: PUSH1 0x00
 */
public class ByteCodeDump extends CodeAnalysisBase {
  public ByteCodeDump(Bytes code) {
    super(code);
  }

  public void dumpContract() {
    ByteCodePrinter printer = new ByteCodePrinter(this.code);
    printer.print(0, this.simple.getEndOfCode() + 1);
  }

  public static final String imm = //"613F76600E600039613F766000F3" +
"0x6080604052348015600f57600080fd5b506004361060285760003560e01c80632420f95714602d575b600080fd5b603c603836600460c9565b603e565b005b60008167ffffffffffffffff811115605657605660e1565b6040519080825280601f01601f191660200182016040528015607f576020820181803683370190505b5080516020820120604051919250907f02e4f1f741a8b106bf9129c4b006a584481f84f330bdb97a4e7ff8445e335c459060bc9083815260200190565b60405180910390a1505050565b60006020828403121560da57600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fdfea2646970667358221220bf98a28a160869a77fac514202ab52b83f22e148ed8616527efb373c274bbd3f64736f6c63430008140033";
//"6054600f3d396034805130553df3fe63906111273d3560e01c14602b57363d3d373d3d3d3d369030545af43d82803e156027573d90f35b3d90fd5b30543d5260203df3";


  public static void main(String[] args) {
//    Bytes code = Bytes.fromHexString(ContractByteCode.contract_0x63de3096c22e89f175c8ed51ca0c129118516979);
//    Bytes code = Bytes.fromHexString(ContractByteCode.contract_0x6475593a8c52aac4059b1eb68235004f136eda5d);
//    Bytes code = Bytes.fromHexString(vyper);
//    Bytes code = Bytes.fromHexString(erc20);
    Bytes code = Bytes.fromHexString(imm);

    ByteCodeDump dump = new ByteCodeDump(code);
    dump.showBasicInfo();
    dump.dumpContract();
  }
}
