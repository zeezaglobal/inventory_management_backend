package com.zeezaglobal.inventory_management_backend.Services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void truncateAllTables() {
        // Fetch all table names from the 'inventorymanagement' schema
        System.out.println("Fetching all table names from the inventorymanagement schema...");

        // Query to fetch table names in the 'inventorymanagement' schema
        List<String> tables = jdbcTemplate.queryForList("SELECT table_name FROM information_schema.tables WHERE table_schema = 'inventorymanagement'", String.class);

        // Check if any tables were found
        if (tables.isEmpty()) {
            System.out.println("No tables found in the 'inventorymanagement' schema.");
        } else {
            // Disable foreign key checks in MySQL
            jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0;");
            System.out.println("Found " + tables.size() + " tables. Truncating tables...");

            // Truncate each table
            for (String table : tables) {
                if (!"hibernate_sequence".equals(table)) { // Exclude Hibernate sequence table
                    System.out.println("Truncating table: " + table);
                    jdbcTemplate.execute("TRUNCATE TABLE `" + table + "`");
                    System.out.println("Successfully truncated table: " + table);
                }
            }

            // Re-enable foreign key checks in MySQL
            jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1;");
            System.out.println("All tables have been truncated successfully.");
        }
    }
}