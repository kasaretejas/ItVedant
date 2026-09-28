import { Navigate, Outlet } from "react-router-dom";


const ProtectedRoutes= ({ roleRequired}) => 
    {
    // const token = localStorage.getItem("token");
    // const role = localStorage.getItem("role");
    const user = JSON.parse(localStorage.getItem("user")); // { role: "VENDOR" or "CUSTOMER" }
    // not logged in
    if (!user) 
        {
            return <Navigate to="/login" replace />;
        }
    // wrong role
    if (user.role !== roleRequired) 
        {
            return <Navigate to="/unauthorized" replace />;
        }
    // render child routes
    return <Outlet />; 
};

export default ProtectedRoutes;
