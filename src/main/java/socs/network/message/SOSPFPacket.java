package socs.network.message;

import java.io.Serializable;
import java.util.Vector;

public class SOSPFPacket implements Serializable {

  //for inter-process communication
  public String srcProcessIP;
  public short srcProcessPort;

  //simulated IP address
  public String srcIP;
  public String dstIP;

  //common header
  public short sospfType; //0 - HELLO, 1 - LinkState Update
  public String routerID;

  //used by HELLO message to identify the sender of the message
  //e.g. when router A sends HELLO to its neighbor, it has to fill this field with its own
  //simulated IP address
  public String neighborID; //neighbor's simulated IP address

  //used by LSAUPDATE
  public Vector<LSA> lsaArray = null;
  public short weight = 0;

  public SOSPFPacket(String srcProcessIP, short srcProcessPort,
                     String srcIP, String dstIP, short sospfType,
                     String routerID, String neighborID, Vector<LSA> lsaArray) {
    this.srcProcessIP = srcProcessIP;
    this.srcProcessPort = srcProcessPort;
    this.srcIP = srcIP;
    this.dstIP = dstIP;
    this.sospfType = sospfType;
    this.routerID = routerID;
    this.neighborID = neighborID;
    this.lsaArray = lsaArray;
  }

  public SOSPFPacket(String srcProcessIP, short srcProcessPort,
                     String srcIP, String dstIP, short sospfType,
                     String routerID, String neighborID, Vector<LSA> lsaArray, short weight) {
    this.srcProcessIP = srcProcessIP;
    this.srcProcessPort = srcProcessPort;
    this.srcIP = srcIP;
    this.dstIP = dstIP;
    this.sospfType = sospfType;
    this.routerID = routerID;
    this.neighborID = neighborID;
    this.lsaArray = lsaArray;
    this.weight = weight;
  }

}
