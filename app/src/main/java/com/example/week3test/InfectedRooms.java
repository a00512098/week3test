package com.example.week3test;

public class InfectedRooms {

    public static void main(String[] args) {
        System.out.println("HorizontalTrue: " + isOutbreak(RoomTests.horizontalTrue, 0, 0, 0));
        System.out.println("MyTestTrue: " + isOutbreak(RoomTests.myTestTrue, 0, 0, 0));
        System.out.println("VerticalTrue: " + isOutbreak(RoomTests.verticalTrue, 0, 0, 0));
        System.out.println("No Infection: " + isOutbreak(RoomTests.noInfection, 0, 0, 0));

    }

    public static boolean isOutbreak(Room[][] rooms, int indexI, int indexJ, int infectedCount) {

        int count = infectedCount;

//        System.out.println(String.format("Room[%d][%d]", indexI, indexJ) + rooms.length + "---" + rooms[0].length);

        if (indexI < rooms.length && indexJ < rooms[0].length) {
            if (rooms[indexI][indexJ].isInfected) {
                count += 1;

                if (count == 5) {
                    return true;
                }

                if (indexJ + 1 < rooms[0].length) { //Check if right index exists
                    if (rooms[indexI][indexJ + 1].isInfected) { // Check neighbour on the right
                        return isOutbreak(rooms, indexI, ++indexJ, count);
                    }
                }

                if (indexI + 1 < rooms.length) { // Check if bottom index exists
                    if (rooms[indexI + 1][indexJ].isInfected) { // Check for neighbour on the bottom
                        return isOutbreak(rooms, ++indexI, indexJ, count);
                    }
                }
            }
        }

        if (indexJ < rooms[0].length) {
            if (indexI < rooms.length)
                return isOutbreak(rooms, indexI, ++indexJ, 0);
            else
                return isOutbreak(rooms, ++indexI, ++indexJ, 0);
        } else if (indexI < rooms.length) {
            return isOutbreak(rooms, ++indexI, 0, 0);
        }

        return false; //both indexes are out of bounds
    }
}
