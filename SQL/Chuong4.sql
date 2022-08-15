--BÀI TẬP CHƯƠNG 4
--4.5.1
--1. Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL)
SELECT DEPTNO, ENAME, (SAL * 0.15) AS PCRSAL
FROM EMP;

--2.Viết câu lệnh hiển thị như sau
SELECT DISTINCT RPAD(ENAME, 10, '*') || LPAD(JOB, 10, '*') AS EMPLOYEE_AND_JOB
FROM EMP;

--3.Viết câu lệnh hiển thị như sau:
SELECT DISTINCT ENAME || ' (' || INITCAP(JOB) || ')' AS EMPLOYEE
FROM EMP;

--4.Viết câu lệnh hiển thị như sau:
SELECT ENAME, DEPTNO, INITCAP(JOB) AS JOB
FROM EMP
WHERE DEPTNO = 30;

--5.Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09 February 1990.
SELECT TO_CHAR(NEXT_DAY(ADD_MONTHS(CURRENT_DATE, 2), 'FRIDAY'), 'DD MONTH YYYY')
FROM DUAL;

--6.Tìm thông itn về tên nhân viên, ngày gia nhập công ty của nhân viên phòng số 20,
--sao cho hiển thị như sau:
SELECT ENAME, LOWER(TO_CHAR(HIREDATE, 'MONTH,')) || TO_CHAR(HIREDATE, 'DAY YYYY') AS DATE_HIRED
FROM EMP
WHERE DEPTNO = 20;

--7.Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia
--nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương
SELECT ENAME, TO_CHAR(HIREDATE, 'DD-MM-YYYY') AS HIREDATE, TO_CHAR(ADD_MONTHS(HIREDATE, 12), 'DD-MM-YYYY') AS REVIEW
FROM EMP
ORDER BY REVIEW;

--8.Hiển thị tên nhân viên và lương dưới dạng
SELECT DISTINCT ENAME,
                (CASE
                     WHEN SAL <= 1500 THEN 'BELOW ' || SAL
                     WHEN SAL > 1500 THEN '' || SAL
                     ELSE 'ON TAGET'
                    END) AS SALARY
FROM EMP;

--9.Cho biết thứ của ngày hiện tại
SELECT TO_CHAR(CURRENT_DATE, 'DAY')
FROM DUAL;

--10.Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại
--là NO. Kiểm tra với các chuỗi 12/34, 01/1a, 99\88
SELECT DECODE('VALUE', '12/34', 'YES', '01/1a', 'NO', '99\88', 'NO', 'UNDEFINE');

--11.Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh
-- lương phải vào thứ 6, nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại
-- công ty, sắp xếp theo thứ tự ngày gia nhập công ty
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, 'FRIDAY') AS LINH_LUONG
FROM EMP
WHERE CURRENT_DATE - HIREDATE >= 15
ORDER BY HIREDATE

-------
--4.5.2
--1. Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên
SELECT ENAME, MIN(SAL) AS MIN_SAL
FROM EMP
GROUP BY ENAME;

SELECT ENAME, MAX(SAL) AS MAX_SAL
FROM EMP
GROUP BY ENAME;

SELECT ENAME, AVG(SAL) AS AVG_SAL
FROM EMP
GROUP BY ENAME;


-- 2. Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp
SELECT JOB ,MIN(SAL) AS MIN_SAL, MAX(SAL) AS MAX_SAL
FROM EMP
GROUP BY JOB;

--3.Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên.
SELECT COUNT(JOB) AS SL_MANAGER
FROM EMP
WHERE JOB = 'MANAGER';

--4. Tìm tất cả các phòng ban mà số nhân viên trong phòng >3
SELECT DEPTNO, COUNT(EMPNO) AS SL_NHANVIEN
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(EMPNO) > 3;

--5. Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó
--sắp xếp theo thứ tự tăng dần của mức lương.
SELECT ENAME,MIN(SAL) AS MIN_SAL, JOB
FROM EMP
WHERE JOB != 'MANAGER' AND JOB != 'PRESIDENT' AND DEPTNO IN (SELECT DEPTNO
                FROM EMP
                WHERE JOB = 'MANAGER')
GROUP BY ENAME,JOB
ORDER BY MIN_SAL ASC;
