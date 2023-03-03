
import java.util.Scanner;
public class CondoManagement {
    public static void pressAnyKey() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to continue...!");
        input.nextLine();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int floor, room = 0;
        String[][] condo = new String[0][];
        boolean isFloorValid = false, isRoomValid = false;
        int option = 0;
        do {
            System.out.println("----------------- Setting Up The Condo -----------------");
            System.out.print("->Enter number of floor : ");
            floor = input.nextInt();

            if (floor > 0) {
                isFloorValid = true;
                System.out.print("->Enter number of room : ");
                room = input.nextInt();
                if (room > 0) {
                    isRoomValid = true;
                    condo = new String[floor][room];
                    System.out.println("===============================================================");
                    System.out.println("You have successfully set up condo");
                    System.out.println("Floor : " + floor + " floor" + ((floor > 1) ? "s" : ""));
                    System.out.println("Room : " + room + " room" + ((room > 1) ? "s" : ""));
                    System.out.println("Total Condo " + (floor * room) + " rooms");
                } else {
                    System.out.println("ROOM CANNOT BE ZERO OR NEGATIVE!");
                }
            } else {
                System.out.println("ROOM CANNOT BE ZERO OR NEGATIVE!");
            }
//           pressAnyKey();
        } while (!isFloorValid || !isRoomValid);

        do {
            System.out.println("######################## Welcome to PP Condo #############################");
            System.out.println("1. Buy condo ");
            System.out.println("2. Sell condo ");
            System.out.println("3. Search condo information ");
            System.out.println("4. Display condo information ");
            System.out.println("5. Exit ");
            System.out.println(".....................................................................");
            System.out.print("->Choose option from (1-5): ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    int desiredRoom;
                    int desiredFloor;
                    String ownerName;
                    int buyOption;
                    boolean isConditionValid = false;
                    do {
                        System.out.println("----------------- Buying the Condo ----------------");
                        System.out.print("Enter number of floor (1 - " + floor + ") : ");
                        desiredFloor = input.nextInt();
                        if (desiredFloor > 0 && desiredFloor <= floor) {
                            isFloorValid = true;
                            System.out.print("Enter number of room (1 - " + room + ") : ");
                            desiredRoom = input.nextInt();
                            if (desiredRoom > 0 && desiredRoom <= room) {
                                if (condo[desiredFloor - 1][desiredRoom - 1] == null) {
                                    isRoomValid = true;
                                    isConditionValid = true;
                                    System.out.print("Enter owner name : ");
                                    input.nextLine();
                                    ownerName = input.nextLine();
                                    condo[desiredFloor - 1][desiredRoom - 1] = ownerName;
                                    System.out.println("Congratulation...! You have successfully bought a condo.");
                                } else {
                                    System.out.println("The room is already owned by someone!");
                                    isRoomValid = false;
                                }
                            } else {
                                System.out.println("Error : Room number is invalid!");
                                isRoomValid = false;
                            }
                        } else {
                            System.out.println("floor start form(1-" + floor + ")");
                        }
//                        if (!isRoomValid || !isFloorValid) {
//                            System.out.println("-------------------------------------------------");
//                            System.out.println("Press 1 to exit and press other number to continue...!");
//                            System.out.println("Choose your option : ");
//                            buyOption = input.nextInt();
//                            if (buyOption == 1) {
//                                isConditionValid = true;
//                            } else {
//                                isConditionValid = false;
//                            }
//                        }

                    } while (!isConditionValid);
                    pressAnyKey();
                    break;
                case 2:
                    String ownerCondoName;
                    boolean isConditionValid1 = false;
                    System.out.println("------------------------- Sell Condo ------------------------");
                    System.out.print("Enter number of floor (1 - " + floor + ") : ");
                    desiredFloor = input.nextInt();
                    System.out.print("Enter number of room (1 - " + room + ") : ");
                    desiredRoom = input.nextInt();
                    System.out.println("Selected Condo Information:");
                    if (desiredFloor > 0 && desiredFloor <= floor && desiredRoom > 0 && desiredRoom <= room) {
                        if (condo[desiredFloor - 1][desiredRoom - 1] != null) {
                            System.out.println("Floor: "+floor+ " Room: "+room+" Belong to: "+condo[desiredFloor-1][desiredRoom-1]);
                            input.nextLine();
                            ownerCondoName = input.nextLine();
//                            switch (option)
                            if (ownerCondoName.equalsIgnoreCase(condo[desiredFloor - 1][desiredRoom - 1])) {
                                // assign
                                condo[desiredFloor - 1][desiredRoom - 1] = null;
                                System.out.println("Congratulation! You sold the condo...!");
                                isRoomValid = false;
                            } else {
                                System.out.println("Error! Valid name is required ");
                                isRoomValid = false;
                            }
                        } else {
                            System.out.println("Sorry! This condo is owning by someone...!");
                            isRoomValid = false;
                        }
                    } else {
                        System.out.println("Error! Floor and room are invalid...!");
                        isRoomValid = false;
                    }
                    pressAnyKey();
                    break;
                case 3:
                    int searchOption = 0;
                    int outOption;
                    boolean isConditionValid2 = false;
                    System.out.println("------------------------ Search Condo Information ----------------------");
                    System.out.println("1. Search by floor");
                    System.out.println("2. Search by name");
                    System.out.println("3. Exit");
                    System.out.print("Choose your option from 1 to 3 : ");
                    searchOption = input.nextInt();
                    switch (searchOption) {
                        case 1:
                            System.out.println("---------------------- Search by floor ------------------------");
                            int searchFloor = 0;
                            System.out.print("Enter the floor to search : ");
                            searchFloor = input.nextInt();
                            if (searchFloor > 0 && searchFloor <= floor) {
                                System.out.print("Floor " + searchFloor + " : ");
                                for (int i = 0; i < condo[searchFloor - 1].length; i++) {
                                    System.out.print("\t" + condo[searchFloor - 1][i]);
                                }
                                System.out.println(); //print new line
                            } else {
                                System.out.println("ERROR! Invalid Floor (Choose from 1 to " + floor + " ) ");
                            }
                            break;
                        case 2:
                            String searchOwnerName;
                            boolean isCondoExit = true;
                            System.out.println("----------------------Search Condo By owner's Name----------------------------");
                            System.out.print("please Owner name to Search : ");
                            input.nextLine();
                            searchOwnerName = input.nextLine();
                            for (int i = 0; i < condo.length; i++) {
                                for (int j = 0; j < condo[i].length; j++) {
                                    if (searchOwnerName.equalsIgnoreCase(condo[i][j])) {
                                        isCondoExit = true;
                                        System.out.println("Owner name "+ searchOwnerName +" stay in my condo floor "+(i+1)+" room "+(j+1));
                                    }
                                }
                            }
                            if (!isCondoExit) {
                                System.out.println("Owner name "+ searchOwnerName +" don't exist in our condos System");
                            }
                            break;
                        case 3:
                            System.out.println("Exiting the program");
                            break;
                        default:
                            System.out.println("you choose wrong option.pleas try again!");
                    }
                    pressAnyKey();
                    break;
                case 4:
                    System.out.println("------------------------- Display Condo information ---------------------");
                    for (int i = (condo.length - 1); i >= 0; i--) {
                        System.out.print("floor[" + (i + 1) + "]=>");
                        for (int j = 0; j < condo[i].length; j++) {
                            System.out.print("\t" + condo[i][j]);
                        }
                        System.out.println();
                    }
                    pressAnyKey();
                    break;
                default:
                    System.out.println("Thanks for use system");
                    break;
            }
        }while(option!=5);
    }
}
