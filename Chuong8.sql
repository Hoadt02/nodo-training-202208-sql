--BÀI TẬP CHƯƠNG 8
--1. Thêm dữ liệu vào bảng PROJECTS
INSERT INTO PROJECT_HOADT (PROJID, P_DESC, P_START_DATE, P_END_DATE, BUDGET_AMOUNT, MAX_NO_SATFF)
VALUES (3,'WRITE C030 COURSE','02-JAN-88','07-JAN-88',500,1)

INSERT INTO PROJECT_HOADT (PROJID, P_DESC, P_START_DATE, P_END_DATE, BUDGET_AMOUNT, MAX_NO_SATFF)
VALUES (4,'PROOF READ NOTES','01-JAN-89','10-JAN-89',600,1)

SELECT * FROM PROJECT_HOADT

--2. Thêm dữ liệu vào bảng ASSIGNMENTS.
INSERT INTO ASSIGNMENTS_HOADT(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE, HOURS)
VALUES (1,7369,'01-JAN-88','03-JAN-88','50.00','WR',15)

INSERT INTO ASSIGNMENTS_HOADT(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE, HOURS)
VALUES (1,7902,'04-JAN-88','07-JAN-88','55.00','WR',20)

INSERT INTO ASSIGNMENTS_HOADT(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE, HOURS)
VALUES (2,7844,'01-JAN-89','07-JAN-89','45.50','PF',30)

SELECT * FROM ASSIGNMENTS_HOADT

--3. Cập nhật trường ASIGNMENT_TYPE từ WT thành WR
UPDATE ASSIGNMENTS_HOADT
SET ASSIGN_TYPE = 'WT'
WHERE ASSIGN_TYPE = 'WR'

--4. Nhập thêm số liệu vào bảng ASSIGNMENTS.
INSERT INTO ASSIGNMENTS_HOADT(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE, HOURS)
VALUES (3,7902,'05-JAN-88','09-JAN-88','50.00','AA',65)

INSERT INTO ASSIGNMENTS_HOADT(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE, HOURS)
VALUES (4,7844,'01-JAN-88','08-JAN-88','50.00','WU',35)
