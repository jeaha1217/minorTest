-- p1_memb
DROP TABLE "회원";

-- p1_stud
DROP TABLE "학생";

-- p1_mgr
DROP TABLE "매니저";

-- pq_tchr
DROP TABLE "강사";

-- p1_board
DROP TABLE "게시판";

-- p1_att_file
DROP TABLE "첨부파일";

-- p1_lect_tchr
DROP TABLE "강의 배정";

-- p1_lect_stud
DROP TABLE "수강생";

-- p1_lect
DROP TABLE "강의";

-- p1_memb
CREATE TABLE "회원" (
    "mno"   INTEGER      NOT NULL, -- 회원 번호
    "name"  VARCHAR(50)  NOT NULL, -- 이름
    "email" VARCHAR(40)  NOT NULL, -- 이메일
    "pwd"   VARCHAR(100) NOT NULL, -- 암호
    "tel"   VARCHAR(30)  NULL,     -- 전화
    "cdt"   DATETIME     NOT NULL  -- 등록일
);

-- p1_memb 기본키
CREATE UNIQUE INDEX "PK_회원"
    ON "회원" ( -- p1_memb
        "mno" ASC -- 회원 번호
    );

-- p1_memb
ALTER TABLE "회원"
    ADD
        CONSTRAINT "PK_회원" -- p1_memb 기본키
        PRIMARY KEY (
            "mno" -- 회원 번호
        );

-- p1_memb
COMMENT ON TABLE "회원" IS 'p1_memb';

-- 회원 번호
COMMENT ON COLUMN "회원"."mno" IS '회원 번호';

-- 이름
COMMENT ON COLUMN "회원"."name" IS '이름';

-- 이메일
COMMENT ON COLUMN "회원"."email" IS '이메일';

-- 암호
COMMENT ON COLUMN "회원"."pwd" IS '암호';

-- 전화
COMMENT ON COLUMN "회원"."tel" IS '전화';

-- 등록일
COMMENT ON COLUMN "회원"."cdt" IS '등록일';

-- p1_memb 기본키
COMMENT ON INDEX "PK_회원" IS 'p1_memb 기본키';

-- p1_memb 기본키
COMMENT ON CONSTRAINT "회원"."PK_회원" IS 'p1_memb 기본키';

-- p1_stud
CREATE TABLE "학생" (
    "mno"  INTEGER     NOT NULL, -- 학생번호
    "schl" VARCHAR(50) NOT NULL, -- 최종학력
    "work" CHAR(1)     NOT NULL  -- 재직 여부
);

-- p1_stud 기본키
CREATE UNIQUE INDEX "PK_학생"
    ON "학생" ( -- p1_stud
        "mno" ASC -- 학생번호
    );

-- p1_stud
ALTER TABLE "학생"
    ADD
        CONSTRAINT "PK_학생" -- p1_stud 기본키
        PRIMARY KEY (
            "mno" -- 학생번호
        );

-- p1_stud
COMMENT ON TABLE "학생" IS 'p1_stud';

-- 학생번호
COMMENT ON COLUMN "학생"."mno" IS '학생번호';

-- 최종학력
COMMENT ON COLUMN "학생"."schl" IS '최종학력';

-- 재직 여부
COMMENT ON COLUMN "학생"."work" IS '재직 여부';

-- p1_stud 기본키
COMMENT ON INDEX "PK_학생" IS 'p1_stud 기본키';

-- p1_stud 기본키
COMMENT ON CONSTRAINT "학생"."PK_학생" IS 'p1_stud 기본키';

-- p1_mgr
CREATE TABLE "매니저" (
    "mno"  INTEGER     NOT NULL, -- 매니저 번호
    "posi" VARCHAR(50) NOT NULL  -- 직위
);

-- p1_mgr 기본키
CREATE UNIQUE INDEX "PK_매니저"
    ON "매니저" ( -- p1_mgr
        "mno" ASC -- 매니저 번호
    );

-- p1_mgr
ALTER TABLE "매니저"
    ADD
        CONSTRAINT "PK_매니저" -- p1_mgr 기본키
        PRIMARY KEY (
            "mno" -- 매니저 번호
        );

-- p1_mgr
COMMENT ON TABLE "매니저" IS 'p1_mgr';

-- 매니저 번호
COMMENT ON COLUMN "매니저"."mno" IS '매니저 번호';

-- 직위
COMMENT ON COLUMN "매니저"."posi" IS '직위';

-- p1_mgr 기본키
COMMENT ON INDEX "PK_매니저" IS 'p1_mgr 기본키';

-- p1_mgr 기본키
COMMENT ON CONSTRAINT "매니저"."PK_매니저" IS 'p1_mgr 기본키';

-- pq_tchr
CREATE TABLE "강사" (
    "tno"   INTEGER      NOT NULL, -- 강사번호
    "hrpay" INTEGER      NOT NULL, -- 시급
    "subj"  VARCHAR(255) NOT NULL  -- 과목
);

-- pq_tchr 기본키
CREATE UNIQUE INDEX "PK_강사"
    ON "강사" ( -- pq_tchr
        "tno" ASC -- 강사번호
    );

-- pq_tchr
ALTER TABLE "강사"
    ADD
        CONSTRAINT "PK_강사" -- pq_tchr 기본키
        PRIMARY KEY (
            "tno" -- 강사번호
        );

-- pq_tchr
COMMENT ON TABLE "강사" IS 'pq_tchr';

-- 강사번호
COMMENT ON COLUMN "강사"."tno" IS '강사번호';

-- 시급
COMMENT ON COLUMN "강사"."hrpay" IS '시급';

-- 과목
COMMENT ON COLUMN "강사"."subj" IS '과목';

-- pq_tchr 기본키
COMMENT ON INDEX "PK_강사" IS 'pq_tchr 기본키';

-- pq_tchr 기본키
COMMENT ON CONSTRAINT "강사"."PK_강사" IS 'pq_tchr 기본키';

-- p1_board
CREATE TABLE "게시판" (
    "bno"  INTEGER      NOT NULL, -- 게시물 번호
    "titl" VARCHAR(255) NOT NULL, -- 제목
    "cont" TEXT         NOT NULL, -- 내용
    "cnt"  INTEGER      NULL,     -- 조회수
    "cdt"  DATETIME     NOT NULL, -- 등록일
    "mno"  INTEGER      NOT NULL  -- 회원 번호
);

-- p1_board 기본키
CREATE UNIQUE INDEX "PK_게시판"
    ON "게시판" ( -- p1_board
        "bno" ASC -- 게시물 번호
    );

-- p1_board
ALTER TABLE "게시판"
    ADD
        CONSTRAINT "PK_게시판" -- p1_board 기본키
        PRIMARY KEY (
            "bno" -- 게시물 번호
        );

-- p1_board
COMMENT ON TABLE "게시판" IS 'p1_board';

-- 게시물 번호
COMMENT ON COLUMN "게시판"."bno" IS '게시물 번호';

-- 제목
COMMENT ON COLUMN "게시판"."titl" IS '제목';

-- 내용
COMMENT ON COLUMN "게시판"."cont" IS '내용';

-- 조회수
COMMENT ON COLUMN "게시판"."cnt" IS '조회수';

-- 등록일
COMMENT ON COLUMN "게시판"."cdt" IS '등록일';

-- 회원 번호
COMMENT ON COLUMN "게시판"."mno" IS '회원 번호';

-- p1_board 기본키
COMMENT ON INDEX "PK_게시판" IS 'p1_board 기본키';

-- p1_board 기본키
COMMENT ON CONSTRAINT "게시판"."PK_게시판" IS 'p1_board 기본키';

-- p1_att_file
CREATE TABLE "첨부파일" (
    "afno"  INTEGER      NOT NULL, -- 파일번호
    "bno"   INTEGER      NOT NULL, -- 게시물 번호
    "fi-nm" VARCHAR(255) NOT NULL  -- 파일 명
);

-- p1_att_file 기본키
CREATE UNIQUE INDEX "PK_첨부파일"
    ON "첨부파일" ( -- p1_att_file
        "afno" ASC -- 파일번호
    );

-- p1_att_file
ALTER TABLE "첨부파일"
    ADD
        CONSTRAINT "PK_첨부파일" -- p1_att_file 기본키
        PRIMARY KEY (
            "afno" -- 파일번호
        );

-- p1_att_file
COMMENT ON TABLE "첨부파일" IS 'p1_att_file';

-- 파일번호
COMMENT ON COLUMN "첨부파일"."afno" IS '파일번호';

-- 게시물 번호
COMMENT ON COLUMN "첨부파일"."bno" IS '게시물 번호';

-- 파일 명
COMMENT ON COLUMN "첨부파일"."fi-nm" IS '파일 명';

-- p1_att_file 기본키
COMMENT ON INDEX "PK_첨부파일" IS 'p1_att_file 기본키';

-- p1_att_file 기본키
COMMENT ON CONSTRAINT "첨부파일"."PK_첨부파일" IS 'p1_att_file 기본키';

-- p1_lect_tchr
CREATE TABLE "강의 배정" (
    "tno" INTEGER NOT NULL, -- 강사번호
    "lno" INTEGER NOT NULL  -- 강의 번호
);

-- p1_lect_tchr 기본키
CREATE UNIQUE INDEX "PK_강의 배정"
    ON "강의 배정" ( -- p1_lect_tchr
        "tno" ASC, -- 강사번호
        "lno" ASC  -- 강의 번호
    );

-- p1_lect_tchr
ALTER TABLE "강의 배정"
    ADD
        CONSTRAINT "PK_강의 배정" -- p1_lect_tchr 기본키
        PRIMARY KEY (
            "tno", -- 강사번호
            "lno"  -- 강의 번호
        );

-- p1_lect_tchr
COMMENT ON TABLE "강의 배정" IS 'p1_lect_tchr';

-- 강사번호
COMMENT ON COLUMN "강의 배정"."tno" IS '강사번호';

-- 강의 번호
COMMENT ON COLUMN "강의 배정"."lno" IS '강의 번호';

-- p1_lect_tchr 기본키
COMMENT ON INDEX "PK_강의 배정" IS 'p1_lect_tchr 기본키';

-- p1_lect_tchr 기본키
COMMENT ON CONSTRAINT "강의 배정"."PK_강의 배정" IS 'p1_lect_tchr 기본키';

-- p1_lect_stud
CREATE TABLE "수강생" (
    "lno" INTEGER NOT NULL, -- 강의 번호
    "mno" INTEGER NOT NULL  -- 학생번호
);

-- p1_lect_stud 기본키
CREATE UNIQUE INDEX "PK_수강생"
    ON "수강생" ( -- p1_lect_stud
        "lno" ASC, -- 강의 번호
        "mno" ASC  -- 학생번호
    );

-- p1_lect_stud
ALTER TABLE "수강생"
    ADD
        CONSTRAINT "PK_수강생" -- p1_lect_stud 기본키
        PRIMARY KEY (
            "lno", -- 강의 번호
            "mno"  -- 학생번호
        );

-- p1_lect_stud
COMMENT ON TABLE "수강생" IS 'p1_lect_stud';

-- 강의 번호
COMMENT ON COLUMN "수강생"."lno" IS '강의 번호';

-- 학생번호
COMMENT ON COLUMN "수강생"."mno" IS '학생번호';

-- p1_lect_stud 기본키
COMMENT ON INDEX "PK_수강생" IS 'p1_lect_stud 기본키';

-- p1_lect_stud 기본키
COMMENT ON CONSTRAINT "수강생"."PK_수강생" IS 'p1_lect_stud 기본키';

-- p1_lect
CREATE TABLE "강의" (
    "lno"    INTEGER      NOT NULL, -- 강의 번호
    "titl"   VARCHAR(255) NOT NULL, -- 강의명
    "dist"   TEXT         NOT NULL, -- 설명
    "sdt"    DATETIME     NOT NULL, -- 시작일
    "edt"    DATETIME     NOT NULL, -- 종료일
    "tot_hr" INTEGER      NOT NULL, -- 총 강의 시간
    "day_hr" INTEGER      NOT NULL, -- 일 강의 시간
    "capa"   INTEGER      NOT NULL, -- 모집 인원
    "mno"    INTEGER      NULL      -- 매니저 번호
);

-- p1_lect 기본키
CREATE UNIQUE INDEX "PK_강의"
    ON "강의" ( -- p1_lect
        "lno" ASC -- 강의 번호
    );

-- p1_lect
ALTER TABLE "강의"
    ADD
        CONSTRAINT "PK_강의" -- p1_lect 기본키
        PRIMARY KEY (
            "lno" -- 강의 번호
        );

-- p1_lect
COMMENT ON TABLE "강의" IS 'p1_lect';

-- 강의 번호
COMMENT ON COLUMN "강의"."lno" IS '강의 번호';

-- 강의명
COMMENT ON COLUMN "강의"."titl" IS '강의명';

-- 설명
COMMENT ON COLUMN "강의"."dist" IS '설명';

-- 시작일
COMMENT ON COLUMN "강의"."sdt" IS '시작일';

-- 종료일
COMMENT ON COLUMN "강의"."edt" IS '종료일';

-- 총 강의 시간
COMMENT ON COLUMN "강의"."tot_hr" IS '총 강의 시간';

-- 일 강의 시간
COMMENT ON COLUMN "강의"."day_hr" IS '일 강의 시간';

-- 모집 인원
COMMENT ON COLUMN "강의"."capa" IS '모집 인원';

-- 매니저 번호
COMMENT ON COLUMN "강의"."mno" IS '매니저 번호';

-- p1_lect 기본키
COMMENT ON INDEX "PK_강의" IS 'p1_lect 기본키';

-- p1_lect 기본키
COMMENT ON CONSTRAINT "강의"."PK_강의" IS 'p1_lect 기본키';

-- p1_stud
ALTER TABLE "학생"
    ADD
        CONSTRAINT "FK_회원_TO_학생" -- p1_memb -> p1_stud
        FOREIGN KEY (
            "mno" -- 학생번호
        )
        REFERENCES "회원" ( -- p1_memb
            "mno" -- 회원 번호
        );

-- p1_memb -> p1_stud
COMMENT ON CONSTRAINT "학생"."FK_회원_TO_학생" IS 'p1_memb -> p1_stud';

-- p1_mgr
ALTER TABLE "매니저"
    ADD
        CONSTRAINT "FK_회원_TO_매니저" -- p1_memb -> p1_mgr
        FOREIGN KEY (
            "mno" -- 매니저 번호
        )
        REFERENCES "회원" ( -- p1_memb
            "mno" -- 회원 번호
        );

-- p1_memb -> p1_mgr
COMMENT ON CONSTRAINT "매니저"."FK_회원_TO_매니저" IS 'p1_memb -> p1_mgr';

-- pq_tchr
ALTER TABLE "강사"
    ADD
        CONSTRAINT "FK_회원_TO_강사" -- p1_memb -> pq_tchr
        FOREIGN KEY (
            "tno" -- 강사번호
        )
        REFERENCES "회원" ( -- p1_memb
            "mno" -- 회원 번호
        );

-- p1_memb -> pq_tchr
COMMENT ON CONSTRAINT "강사"."FK_회원_TO_강사" IS 'p1_memb -> pq_tchr';

-- p1_board
ALTER TABLE "게시판"
    ADD
        CONSTRAINT "FK_회원_TO_게시판" -- p1_memb -> p1_board
        FOREIGN KEY (
            "mno" -- 회원 번호
        )
        REFERENCES "회원" ( -- p1_memb
            "mno" -- 회원 번호
        );

-- p1_memb -> p1_board
COMMENT ON CONSTRAINT "게시판"."FK_회원_TO_게시판" IS 'p1_memb -> p1_board';

-- p1_att_file
ALTER TABLE "첨부파일"
    ADD
        CONSTRAINT "FK_게시판_TO_첨부파일" -- p1_board -> p1_att_file
        FOREIGN KEY (
            "bno" -- 게시물 번호
        )
        REFERENCES "게시판" ( -- p1_board
            "bno" -- 게시물 번호
        );

-- p1_board -> p1_att_file
COMMENT ON CONSTRAINT "첨부파일"."FK_게시판_TO_첨부파일" IS 'p1_board -> p1_att_file';

-- p1_lect_tchr
ALTER TABLE "강의 배정"
    ADD
        CONSTRAINT "FK_강사_TO_강의 배정" -- pq_tchr -> p1_lect_tchr
        FOREIGN KEY (
            "tno" -- 강사번호
        )
        REFERENCES "강사" ( -- pq_tchr
            "tno" -- 강사번호
        );

-- pq_tchr -> p1_lect_tchr
COMMENT ON CONSTRAINT "강의 배정"."FK_강사_TO_강의 배정" IS 'pq_tchr -> p1_lect_tchr';

-- p1_lect_tchr
ALTER TABLE "강의 배정"
    ADD
        CONSTRAINT "FK_강의_TO_강의 배정" -- p1_lect -> p1_lect_tchr
        FOREIGN KEY (
            "lno" -- 강의 번호
        )
        REFERENCES "강의" ( -- p1_lect
            "lno" -- 강의 번호
        );

-- p1_lect -> p1_lect_tchr
COMMENT ON CONSTRAINT "강의 배정"."FK_강의_TO_강의 배정" IS 'p1_lect -> p1_lect_tchr';

-- p1_lect_stud
ALTER TABLE "수강생"
    ADD
        CONSTRAINT "FK_강의_TO_수강생" -- p1_lect -> p1_lect_stud
        FOREIGN KEY (
            "lno" -- 강의 번호
        )
        REFERENCES "강의" ( -- p1_lect
            "lno" -- 강의 번호
        );

-- p1_lect -> p1_lect_stud
COMMENT ON CONSTRAINT "수강생"."FK_강의_TO_수강생" IS 'p1_lect -> p1_lect_stud';

-- p1_lect_stud
ALTER TABLE "수강생"
    ADD
        CONSTRAINT "FK_학생_TO_수강생" -- p1_stud -> p1_lect_stud
        FOREIGN KEY (
            "mno" -- 학생번호
        )
        REFERENCES "학생" ( -- p1_stud
            "mno" -- 학생번호
        );

-- p1_stud -> p1_lect_stud
COMMENT ON CONSTRAINT "수강생"."FK_학생_TO_수강생" IS 'p1_stud -> p1_lect_stud';

-- p1_lect
ALTER TABLE "강의"
    ADD
        CONSTRAINT "FK_매니저_TO_강의" -- p1_mgr -> p1_lect
        FOREIGN KEY (
            "mno" -- 매니저 번호
        )
        REFERENCES "매니저" ( -- p1_mgr
            "mno" -- 매니저 번호
        );

-- p1_mgr -> p1_lect
COMMENT ON CONSTRAINT "강의"."FK_매니저_TO_강의" IS 'p1_mgr -> p1_lect';