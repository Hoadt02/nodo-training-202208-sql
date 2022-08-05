-- BÀI TẬP CHƯƠNG 5
--1. Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng ban
SELECT E.ENAME, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO

--2. Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
SELECT E.ENAME, D.LOC, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.SAL > 1500;

--3. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương.
SELECT DISTINCT ENAME, JOB, SAL, S.GRADE
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;

--4. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức lương=3.
SELECT DISTINCT ENAME, JOB, SAL, S.GRADE
FROM EMP E, SALGRADE S
WHERE S.GRADE = 3 AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

--5. Hiển thị những nhân viên tại DALLAS
SELECT E.ENAME,D.LOC,E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.LOC = 'DALLAS';


--6. Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
--viên có nghề là cleck và sắp xếp theo chiều giảm.
SELECT E.ENAME, E.JOB, E.SAL, S.GRADE, D.DNAME
FROM EMP E, SALGRADE S, DEPT D
WHERE (E.DEPTNO = D.DEPTNO) AND (E.SAL BETWEEN S.LOSAL AND S.HISAL) AND E.JOB != 'CLERK'
ORDER BY D.DNAME DESC;

--7. Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là cleck.
-- (gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
SELECT E.ENAME, E.JOB, E.SAL, D.DEPTNO, D.DNAME, S.GRADE
FROM EMP E, SALGRADE S, DEPT D
WHERE (E.DEPTNO = D.DEPTNO) AND (E.SAL BETWEEN S.LOSAL AND S.HISAL)
                            AND (E.SAL * 12 >= 36000 OR E.JOB = 'CLERK');

--8. Hiển thị những phòng không có nhân viên nào làm việc.
SELECT *
FROM DEPT
WHERE DEPTNO NOT IN (SELECT DISTINCT DEPTNO
                     FROM EMP
                     WHERE DEPTNO IS NOT NULL);

--9. Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
SELECT E.ENAME EMP_NAME, E.SAL EMP_SAL , M.MGR MGR_NAME , M.SAL MGR_SAL
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO AND E.SAL < M.SAL;

--10. Như câu 9 hiển thị thêm thông tin về ông KING

--11. Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào
-- năm 1994
SELECT DISTINCT JOB
FROM EMP
WHERE TO_CHAR(HIREDATE,'YYYY') = 1981 AND JOB NOT IN (SELECT DISTINCT JOB
                                                      FROM EMP
                                                      WHERE TO_CHAR(HIREDATE,'YYYY') = 1994)

--12. Tìm những nhân viên gia nhập công ty trước giám đốc của họ.
SELECT *
FROM EMP
WHERE JOB != 'MANAGER' AND HIREDATE < ALL (SELECT HIREDATE
                  FROM EMP
                  WHERE JOB = 'MANAGER')

--13.Tìm tất cả các nhân viên, ngày gia nhập công ty, tên nhân viên, tên người giám đốc
--và ngày gia nhập công ty của người giám đốc ấy

--14. Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.
SELECT JOB ,MAX(SAL) AS LUONG_CAO_NHAT
FROM EMP
WHERE JOB IS NOT NULL
GROUP BY JOB

--15. Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban.
SELECT ENAME, JOB, DEPTNO, SAL
FROM EMP
WHERE SAL = ANY (
    SELECT MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO
)
