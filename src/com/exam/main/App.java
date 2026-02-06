package com.exam.main;

import com.exam.dao.RoomDAO;
import com.exam.dao.StudentDAO;
import com.exam.service.AllocationService;
import com.exam.strategy.HillClimbingStrategy;
import com.exam.strategy.SeatingStrategy;
import com.exam.model.Seat;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Setup & Run ---");

        RoomDAO roomDAO = new RoomDAO();
        StudentDAO studentDAO = new StudentDAO();
        long validRoomId = -1;

        try {
            // Try to add a fresh room to GUARANTEE we have one.
            // We use a random number in the name to avoid "Duplicate Entry" errors if you run this twice.
            String roomName = "FinalExamRoom_" + System.currentTimeMillis() % 1000;
            System.out.println("Creating new room: " + roomName);

            roomDAO.addRoom(roomName, 2, 2); // 2 rows, 2 cols = 4 seats
        } catch (Exception e) {
            System.out.println("Room creation note: " + e.getMessage());
        }
        for(long i = 1; i <= 10; i++) {
            List<Seat> seats = roomDAO.getSeatsByRoomId(i);
            if(!seats.isEmpty()) {
                System.out.println("FOUND VALID ROOM! ID: " + i + " has " + seats.size() + " seats.");
                validRoomId = i;
                break; // Stop at the first valid room
            }
        }

        if (validRoomId == -1) {
            System.err.println("CRITICAL ERROR: No rooms with seats found in DB (Checked IDs 1-10).");
            System.err.println("Please check your 'seats' table in MySQL Workbench.");
            return;
        }
        try { studentDAO.addStudent("CS101", "Alice", "a@test.com", "CSE"); } catch (Exception e) {}
        try { studentDAO.addStudent("CS102", "Bob", "b@test.com", "CSE"); } catch (Exception e) {}
        try { studentDAO.addStudent("EC101", "Charlie", "c@test.com", "ECE"); } catch (Exception e) {}

        System.out.println("--- Running Service using Room ID: " + validRoomId + " ---");

        SeatingStrategy aiStrategy = new HillClimbingStrategy();
        AllocationService service = new AllocationService();

        service.generateSeating(99, validRoomId, aiStrategy);
    }
}
