-- functions are set of sql queries, execute only when we call it
-- diff between functions and SP
-- 1. function compulsory returns a value where in SP, returning value is not compulsory
-- 2. function returns only one value, SP can return multiple values
-- 3. we call functions using select whereas we call SP using call
-- 4. we can only write select queries in function where we can write DQL and DML in SP


-- create function in SQL to get employee count



-- CREATE  FUNCTION `empCount`() RETURNS int
--     DETERMINISTIC
-- BEGIN
-- 	declare count int default 0;
--     select count(id) into count from employee;
-- RETURN count;
-- END
select empCount();