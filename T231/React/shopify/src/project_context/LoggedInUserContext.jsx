import { createContext, useState } from "react";

export const LoggedInUserContext = createContext();

export default function LoggedInUserProvider({ children }) {
  let loggendInUserData=JSON.parse(localStorage.getItem("userData"))

  const [userData, setUserData] = useState(loggendInUserData);

  return (
    <LoggedInUserContext.Provider value={{ userData, setUserData }}>
      {children}
    </LoggedInUserContext.Provider>
  );
}