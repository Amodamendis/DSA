/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Administrator
 */
import java.sql.*;
import model.ToolModel;
import view.toolmonitor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class ToolController {
          // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public boolean borrowTool(ToolModel tool) {
        String sql = "INSERT INTO tool (Toolname, Connu, handovertime) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, tool.getToolName());
            pstmt.setInt(2, tool.getConnu());
            pstmt.setString(3, tool.getHandoverTime());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<ToolModel> getAllTools() {
        List<ToolModel> tools = new ArrayList<>();
        String sql = "SELECT * FROM tool";
        
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String toolname = rs.getString("toolname");
                int connu = rs.getInt("connu");
                String handovertime = rs.getString("handovertime");
                
                tools.add(new ToolModel(toolname, connu, handovertime));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tools;
    }
    
    public void updateTableModel(javax.swing.JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        
        List<ToolModel> tools = getAllTools();
        
        for (ToolModel tool : tools) {
            Object[] row = {
                tool.getToolName(),
                tool.getConnu(),
                tool.getHandoverTime()
            };
            model.addRow(row);
        }
    }
    public boolean clearAllTools() {
        String sql = "DELETE FROM tool";
        
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            int rowsAffected = stmt.executeUpdate(sql);
            return true; // Return true even if no rows were deleted
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
}
