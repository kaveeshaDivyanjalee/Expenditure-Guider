package Servelets;



import Model.UserProfile;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Controller.DBConection;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SubmitUserProfile")
@MultipartConfig
public class UserProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            try {
				createUserProfile(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if ("update".equals(action)) {
            try {
				updateUserProfile(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    // Create User Profile
    private void createUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(request.getParameter("first_name"));
        userProfile.setLastName(request.getParameter("last_name"));
        userProfile.setEmail(request.getParameter("email"));
        userProfile.setMobile(request.getParameter("mobile"));
        userProfile.setExperience(request.getParameter("experience"));
        userProfile.setPassword(request.getParameter("password"));


        // Handle file upload
        Part filePart = request.getPart("profile_image");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            userProfile.setProfileImage(fileName);
        }

        try (Connection conn = DBConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO user_profiles (first_name, last_name, email, mobile, experience, profile_image,password) VALUES (?, ?, ?, ?, ?, ?,?)")) {
            stmt.setString(1, userProfile.getFirstName());
            stmt.setString(2, userProfile.getLastName());
            stmt.setString(3, userProfile.getEmail());
            stmt.setString(4, userProfile.getMobile());
            stmt.setString(5, userProfile.getExperience());
            stmt.setString(6, userProfile.getProfileImage());
            stmt.setString(7, userProfile.getPassword());

            stmt.executeUpdate();
            response.sendRedirect("SubmitUserProfile?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error creating profile: " + e.getMessage());
        }
    }

    // Update User Profile
    private void updateUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(Integer.parseInt(request.getParameter("id"))); // Set the ID for update
        userProfile.setFirstName(request.getParameter("first_name"));
        userProfile.setLastName(request.getParameter("last_name"));
        userProfile.setEmail(request.getParameter("email"));
        userProfile.setMobile(request.getParameter("mobile"));
        userProfile.setExperience(request.getParameter("experience"));
        userProfile.setPassword(request.getParameter("password"));


        // Handle file upload
        Part filePart = request.getPart("profile_image");
        String oldImage = null;

        // Check if a file is uploaded and handle image update
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            userProfile.setProfileImage(fileName);
        } else {
            // If no new image is uploaded, retain the old image
            try (Connection conn = DBConection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT profile_image FROM user_profiles WHERE id = ?")) {
                stmt.setInt(1, userProfile.getId());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    oldImage = rs.getString("profile_image");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            userProfile.setProfileImage(oldImage);
        }

        try (Connection conn = DBConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE user_profiles SET first_name = ?, last_name = ?, email = ?, mobile = ?, experience = ?, profile_image = ?, password = ? WHERE id = ?")) {
            stmt.setString(1, userProfile.getFirstName());
            stmt.setString(2, userProfile.getLastName());
            stmt.setString(3, userProfile.getEmail());
            stmt.setString(4, userProfile.getMobile());
            stmt.setString(5, userProfile.getExperience());
            stmt.setString(6, userProfile.getProfileImage());
            stmt.setString(7, userProfile.getPassword());
            stmt.setInt(8, userProfile.getId());

            stmt.executeUpdate();
            response.sendRedirect("SubmitUserProfile?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error updating profile: " + e.getMessage());
        }
    }

    // Handles GET requests for listing user profiles
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            try {
				deleteUserProfile(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if ("edit".equals(action)) {
            try {
				editUserProfile(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if ("list".equals(action)) {
            try {
				listProfiles(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

    // Delete user profile
    private void deleteUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_profiles WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            response.sendRedirect("SubmitUserProfile?action=list"); // Redirect to list profiles after deletion

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error deleting profile: " + e.getMessage());
        }
    }

    // Edit user profile
    private void editUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_profiles WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                UserProfile userProfile = new UserProfile();
                userProfile.setId(rs.getInt("id"));
                userProfile.setFirstName(rs.getString("first_name"));
                userProfile.setLastName(rs.getString("last_name"));
                userProfile.setEmail(rs.getString("email"));
                userProfile.setMobile(rs.getString("mobile"));
                userProfile.setExperience(rs.getString("experience"));
                userProfile.setProfileImage(rs.getString("profile_image"));
                
                // Set the userProfile attribute for JSP
                request.setAttribute("profile", userProfile); // Ensure the attribute name matches with JSP

                // Forward to the JSP page
                RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle case where no profile is found for the given id
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Profile not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error fetching profile for edit: " + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().write("Invalid ID format: " + e.getMessage());
        }
    }


    // List user profiles
    private void listProfiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<UserProfile> profiles = new ArrayList<>();
        try (Connection conn = DBConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_profiles");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserProfile profile = new UserProfile();
                profile.setId(rs.getInt("id"));
                profile.setFirstName(rs.getString("first_name"));
                profile.setLastName(rs.getString("last_name"));
                profile.setEmail(rs.getString("email"));
                profile.setMobile(rs.getString("mobile"));
                profile.setExperience(rs.getString("experience"));
                profile.setProfileImage(rs.getString("profile_image")); 
                profile.setPassword(rs.getString("password"));
                profiles.add(profile);
            }
            request.setAttribute("profiles", profiles);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error retrieving profiles: " + e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("profiles.jsp");
        dispatcher.forward(request, response);
    }

}
