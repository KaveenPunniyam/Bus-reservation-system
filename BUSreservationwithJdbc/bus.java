package BUSreservationwithJdbc;

public class bus {
  private int busNo;
  private boolean ac;
  private int capacity;

  bus(int no, boolean ac, int cap) {
    this.busNo = no;
    this.ac = ac;
    this.capacity = cap;

  }

  public int getbusNo() {
    return busNo;
  }

  public boolean getAc() {
    return ac;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setbusNo(int bus) {
    busNo = bus;
  }

  public void setAc(boolean val) {
    ac = val;
  }

  public void setcapacity(int cap) {
    capacity = cap;
  }

  public void displayBusInfo() {
    System.out.println("Bus No: " + busNo + " AC: " + ac + " Total capacity " + capacity);
  }
}
