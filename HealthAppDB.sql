toc.dat                                                                                             0000600 0004000 0002000 00000026304 14611666666 0014466 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP   *    +                |        	   HealthApp    16.1    16.1 &    1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         4           1262    19616 	   HealthApp    DATABASE     m   CREATE DATABASE "HealthApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE "HealthApp";
                malerie    false         �            1259    19618    users    TABLE        CREATE TABLE public.users (
    user_id integer NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    is_doctor boolean NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false         �            1259    19634    doctor    TABLE     �   CREATE TABLE public.doctor (
    dr_id integer NOT NULL,
    "medLicenseNum" character varying NOT NULL,
    specialization character varying NOT NULL,
    "patientList" character varying NOT NULL
)
INHERITS (public.users);
    DROP TABLE public.doctor;
       public         heap    postgres    false    216         �            1259    19633    doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.doctor_id_seq;
       public          postgres    false    218         5           0    0    doctor_id_seq    SEQUENCE OWNED BY     B   ALTER SEQUENCE public.doctor_id_seq OWNED BY public.doctor.dr_id;
          public          postgres    false    217         �            1259    19718    health_data    TABLE     �  CREATE TABLE public.health_data (
    health_id integer NOT NULL,
    user_id integer NOT NULL,
    gender character varying NOT NULL,
    age integer NOT NULL,
    weight double precision NOT NULL,
    height double precision NOT NULL,
    rest_heart_rate integer NOT NULL,
    active_heart_rate integer NOT NULL,
    blood_pressure character varying NOT NULL,
    blood_sugar double precision NOT NULL,
    steps integer NOT NULL,
    cardio_minutes double precision NOT NULL,
    hours_slept integer NOT NULL,
    date character varying NOT NULL,
    med_list character varying NOT NULL,
    allergies character varying NOT NULL,
    med_history character varying NOT NULL,
    dr_id integer NOT NULL
);
    DROP TABLE public.health_data;
       public         heap    malerie    false         �            1259    19644    med_reminder    TABLE     -  CREATE TABLE public.med_reminder (
    med_id integer NOT NULL,
    user_id integer NOT NULL,
    med_name character varying NOT NULL,
    dosage character varying NOT NULL,
    schedule character varying NOT NULL,
    start_date character varying NOT NULL,
    end_date character varying NOT NULL
);
     DROP TABLE public.med_reminder;
       public         heap    postgres    false         �            1259    19643    medicineReminder_id_seq    SEQUENCE     �   CREATE SEQUENCE public."medicineReminder_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."medicineReminder_id_seq";
       public          postgres    false    220         6           0    0    medicineReminder_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public."medicineReminder_id_seq" OWNED BY public.med_reminder.med_id;
          public          postgres    false    219         �            1259    19726    recommendations    TABLE     {   CREATE TABLE public.recommendations (
    recommend_id integer NOT NULL,
    recommendations character varying NOT NULL
);
 #   DROP TABLE public.recommendations;
       public         heap    malerie    false         �            1259    19725     recommendations_recommend_id_seq    SEQUENCE     �   CREATE SEQUENCE public.recommendations_recommend_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.recommendations_recommend_id_seq;
       public          malerie    false    224         7           0    0     recommendations_recommend_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.recommendations_recommend_id_seq OWNED BY public.recommendations.recommend_id;
          public          malerie    false    223         �            1259    19617    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false    216         8           0    0    users_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;
          public          postgres    false    215         �            1259    19717    users_user_id_seq1    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_user_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216         �           2604    19638    doctor dr_id    DEFAULT     i   ALTER TABLE ONLY public.doctor ALTER COLUMN dr_id SET DEFAULT nextval('public.doctor_id_seq'::regclass);
 ;   ALTER TABLE public.doctor ALTER COLUMN dr_id DROP DEFAULT;
       public          postgres    false    217    218    218         �           2604    19647    med_reminder med_id    DEFAULT     |   ALTER TABLE ONLY public.med_reminder ALTER COLUMN med_id SET DEFAULT nextval('public."medicineReminder_id_seq"'::regclass);
 B   ALTER TABLE public.med_reminder ALTER COLUMN med_id DROP DEFAULT;
       public          postgres    false    220    219    220         (          0    19634    doctor 
   TABLE DATA           �   COPY public.doctor (user_id, first_name, last_name, email, password, is_doctor, dr_id, "medLicenseNum", specialization, "patientList") FROM stdin;
    public          postgres    false    218       3624.dat ,          0    19718    health_data 
   TABLE DATA           �   COPY public.health_data (health_id, user_id, gender, age, weight, height, rest_heart_rate, active_heart_rate, blood_pressure, blood_sugar, steps, cardio_minutes, hours_slept, date, med_list, allergies, med_history, dr_id) FROM stdin;
    public          malerie    false    222       3628.dat *          0    19644    med_reminder 
   TABLE DATA           i   COPY public.med_reminder (med_id, user_id, med_name, dosage, schedule, start_date, end_date) FROM stdin;
    public          postgres    false    220       3626.dat .          0    19726    recommendations 
   TABLE DATA           H   COPY public.recommendations (recommend_id, recommendations) FROM stdin;
    public          malerie    false    224       3630.dat &          0    19618    users 
   TABLE DATA           [   COPY public.users (user_id, first_name, last_name, email, password, is_doctor) FROM stdin;
    public          postgres    false    216       3622.dat 9           0    0    doctor_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.doctor_id_seq', 1, false);
          public          postgres    false    217         :           0    0    medicineReminder_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."medicineReminder_id_seq"', 1, false);
          public          postgres    false    219         ;           0    0     recommendations_recommend_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.recommendations_recommend_id_seq', 1, false);
          public          malerie    false    223         <           0    0    users_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);
          public          postgres    false    215         =           0    0    users_user_id_seq1    SEQUENCE SET     A   SELECT pg_catalog.setval('public.users_user_id_seq1', 25, true);
          public          postgres    false    221         �           2606    19642    doctor doctor_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (dr_id);
 <   ALTER TABLE ONLY public.doctor DROP CONSTRAINT doctor_pkey;
       public            postgres    false    218         �           2606    19724    health_data healthData_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.health_data
    ADD CONSTRAINT "healthData_pkey" PRIMARY KEY (health_id);
 G   ALTER TABLE ONLY public.health_data DROP CONSTRAINT "healthData_pkey";
       public            malerie    false    222         �           2606    19651    med_reminder id 
   CONSTRAINT     Q   ALTER TABLE ONLY public.med_reminder
    ADD CONSTRAINT id PRIMARY KEY (med_id);
 9   ALTER TABLE ONLY public.med_reminder DROP CONSTRAINT id;
       public            postgres    false    220         �           2606    19733 $   recommendations recommendations_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.recommendations
    ADD CONSTRAINT recommendations_pkey PRIMARY KEY (recommend_id);
 N   ALTER TABLE ONLY public.recommendations DROP CONSTRAINT recommendations_pkey;
       public            malerie    false    224         �           2606    19625    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216         �           1259    19662    fki_user_id    INDEX     A   CREATE INDEX fki_user_id ON public.doctor USING btree (user_id);
    DROP INDEX public.fki_user_id;
       public            postgres    false    218         �           2606    19652    med_reminder user_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.med_reminder
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON UPDATE CASCADE;
 >   ALTER TABLE ONLY public.med_reminder DROP CONSTRAINT user_id;
       public          postgres    false    3466    216    220         �           2606    19657    doctor user_id    FK CONSTRAINT     r   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id);
 8   ALTER TABLE ONLY public.doctor DROP CONSTRAINT user_id;
       public          postgres    false    216    218    3466                                                                                                                                                                                                                                                                                                                                    3624.dat                                                                                            0000600 0004000 0002000 00000001374 14611666666 0014277 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	John	Smith	john@example.com	password123	t	1	MD123456	Cardiology	{}
2	Emily	Johnson	emily@example.com	password456	t	2	MD789012	Pediatrics	{}
3	Michael	Williams	michael@example.com	password789	t	3	MD345678	Orthopedics	{}
4	Sarah	Brown	sarah@example.com	passwordabc	t	4	MD901234	Dermatology	{}
5	David	Jones	david@example.com	passworddef	t	5	MD567890	Ophthalmology	{}
6	Jennifer	Martinez	jennifer@example.com	passwordghi	t	6	MD654321	Neurology	{}
7	Christopher	Garcia	christopher@example.com	passwordjkl	t	7	MD210987	Gastroenterology	{}
8	Jessica	Rodriguez	jessica@example.com	passwordmno	t	8	MD876543	Endocrinology	{}
9	James	Hernandez	james@example.com	passwordpqr	t	9	MD432109	Urology	{}
10	Mary	Lopez	mary@example.com	passwordstu	t	10	MD098765	Oncology	{}
\.


                                                                                                                                                                                                                                                                    3628.dat                                                                                            0000600 0004000 0002000 00000002115 14611666666 0014275 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1	Female	33	82	150	80	120	120/80	5	10000	30	8	2021-10-01	Ibuprofen, Birth Control	Amoxicillin	Fibromyalgia	1
11	11	Female	33	82	150	80	100	120/80	5	10000	30	8	2021-10-01	Ibuprofen, Birth Control	Amoxicillin	Fibromyalgia	1
2	2	Female	35	65	160	75	95	118/78	4.5	12000	25	7	2021-09-30	Aspirin	Penicillin	None	2
4	4	Male	45	90	175	85	110	124/80	5.5	15000	40	8	2021-09-28	Vitamin D	None	None	4
6	6	Male	28	80	180	82	98	120/80	4.7	11000	25	8	2021-09-26	Vitamin C	Pollen	None	6
7	7	Female	50	60	160	65	90	110/70	4.2	7000	20	6	2021-09-25	Calcium	Peanuts	Asthma	7
9	9	Male	38	70	170	75	100	124/78	4.5	10000	35	8	2021-09-23	Omega-3	Pollen	None	9
10	10	Female	32	75	165	72	95	118/76	4.8	13000	40	6	2021-09-22	Vitamin B12	Pollen	Anemia	10
3	3	Male	40	75.5	170	78	105	122/82	5.2	8000	35	6	2021-09-29	Paracetamol	Sulfa	Hypertension	1
5	5	Female	30	70	155	70	95	115/75	4	9000	30	7	2021-09-27	Fish Oil	None	None	1
8	8	Male	55	85	175	80	105	128/82	5	12000	30	7	2021-09-24	Magnesium	None	Diabetes	1
22	22	Female	33	82	150	80	100	120/80	5	10000	30	8	2021-10-01	Ibuprofen, Birth Control	Amoxicillin	Fibromyalgia	1
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                   3626.dat                                                                                            0000600 0004000 0002000 00000000073 14611666666 0014274 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1	Ibuprofen	400	Daily	April 20, 2024	April 24, 2024
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                     3630.dat                                                                                            0000600 0004000 0002000 00000006623 14611666666 0014276 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	"The recommended resting heart rate is between 60 and 100 beats per minute." + "Generally, a lower heart rate at rest implies more efficient heart function and better cardiovascular fitness."
2	"Your heart rate is lower than the recommended range. " +\n                    "Consider increasing your physical activity to improve your cardiovascular health."
3	"Your heart rate is higher than the recommended range. " +\n                    "Consider reducing stress and incorporating relaxation techniques into your daily routine."
4	"Your target heart rate is below the recommended range." +\n                    "Consider adjusting your exercise intensity to stay within the target heart rate zone."
5	"Your target heart rate is above the recommended range." +\n                    "Consider adjusting your exercise intensity to stay within the target heart rate zone."
6	"The recommended blood pressure is below 120/80 mm Hg."
7	"Your blood pressure is above the recommended range. " +\n                    "Consider monitoring your blood pressure regularly and consulting with a healthcare provider."
8	"Your blood pressure is in the elevated hypertensive range. " +\n                    "Consider consulting with a healthcare provider to address any potential health concerns."
9	"Your blood pressure is in the hypertensive range - stage 1. " +\n                    "Consider consulting with a healthcare provider to address any potential health concerns."
10	Your blood pressure is in the severely hypertensive - stage 2 range. " +\n                    "Consider consulting with a healthcare provider to address any potential health concerns."
11	"Your blood pressure is in the hypertensive crisis range. " +\n                    "Seek immediate medical attention."
12	"Your blood sugar level is within the recommended range for children. " + "Keep up the good work!"
13	"Your blood sugar level is within the recommended range for adults. " + "Keep up the good work!"
14	"Your blood sugar level is HIGHER than the recommended range." + "Consider consulting with a healthcare provider to address any potential health concerns."
15	"Your blood sugar level is HIGHER than recommended, consider getting immediate medical attention."
16	"Your blood sugar level is LOWER than recommended, consider getting immediate medical attention."
17	"You're not reaching the recommended daily step count. " +\n                    "Try to incorporate more walking or other physical activities into your daily routine."
18	"You're not getting enough sleep. " +\n                    "Consider improving your sleep hygiene and creating a bedtime routine to ensure adequate rest."
19	"You're getting enough sleep according to experts. " +\n                    "Keep up the good work!"
20	"You're getting more sleep than recommended. " +\n                        "Consider adjusting your sleep schedule to ensure quality rest."
21	"Your BMI is below the healthy range. " +\n                    "Consider consulting with a healthcare provider to address any potential health concerns."
22	"Your BMI is within the healthy range. " +\n                    "Keep up the good work!"
23	"Your BMI is above the healthy range. " +\n                    "Consider consulting with a healthcare provider to address any potential health concerns."
24	"Your BMI is in the obese range. " +\n                    "Consider consulting with a healthcare provider to address any potential health concerns."
\.


                                                                                                             3622.dat                                                                                            0000600 0004000 0002000 00000001402 14611666666 0014265 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Malerie	Augot	malerie.earle@keyin.com	password	f
2	Alice	Smith	alice@example.com	password123	f
3	Bob	Johnson	bob@example.com	password456	f
4	Charlie	Williams	charlie@example.com	password789	f
5	David	Brown	david@example.com	password123	f
6	Emily	Jones	emily@example.com	password456	f
7	Frank	Davis	frank@example.com	password789	f
8	Grace	Miller	grace@example.com	password123	f
9	Henry	Wilson	henry@example.com	password456	f
10	Isabella	Taylor	isabella@example.com	password789	f
11	Jack	Anderson	jack@example.com	password123	f
12	Katherine	Thomas	katherine@example.com	password456	f
13	Liam	Lee	liam@example.com	password789	f
14	Mia	Harris	mia@example.com	password123	f
15	Noah	Clark	noah@example.com	password456	f
16	Olivia	Lewis	olivia@example.com	password789	f
\.


                                                                                                                                                                                                                                                              restore.sql                                                                                         0000600 0004000 0002000 00000024017 14611666666 0015412 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "HealthApp";
--
-- Name: HealthApp; Type: DATABASE; Schema: -; Owner: malerie
--

CREATE DATABASE "HealthApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';


ALTER DATABASE "HealthApp" OWNER TO malerie;

\connect "HealthApp"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    is_doctor boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: doctor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doctor (
    dr_id integer NOT NULL,
    "medLicenseNum" character varying NOT NULL,
    specialization character varying NOT NULL,
    "patientList" character varying NOT NULL
)
INHERITS (public.users);


ALTER TABLE public.doctor OWNER TO postgres;

--
-- Name: doctor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.doctor_id_seq OWNER TO postgres;

--
-- Name: doctor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.doctor_id_seq OWNED BY public.doctor.dr_id;


--
-- Name: health_data; Type: TABLE; Schema: public; Owner: malerie
--

CREATE TABLE public.health_data (
    health_id integer NOT NULL,
    user_id integer NOT NULL,
    gender character varying NOT NULL,
    age integer NOT NULL,
    weight double precision NOT NULL,
    height double precision NOT NULL,
    rest_heart_rate integer NOT NULL,
    active_heart_rate integer NOT NULL,
    blood_pressure character varying NOT NULL,
    blood_sugar double precision NOT NULL,
    steps integer NOT NULL,
    cardio_minutes double precision NOT NULL,
    hours_slept integer NOT NULL,
    date character varying NOT NULL,
    med_list character varying NOT NULL,
    allergies character varying NOT NULL,
    med_history character varying NOT NULL,
    dr_id integer NOT NULL
);


ALTER TABLE public.health_data OWNER TO malerie;

--
-- Name: med_reminder; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.med_reminder (
    med_id integer NOT NULL,
    user_id integer NOT NULL,
    med_name character varying NOT NULL,
    dosage character varying NOT NULL,
    schedule character varying NOT NULL,
    start_date character varying NOT NULL,
    end_date character varying NOT NULL
);


ALTER TABLE public.med_reminder OWNER TO postgres;

--
-- Name: medicineReminder_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."medicineReminder_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."medicineReminder_id_seq" OWNER TO postgres;

--
-- Name: medicineReminder_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."medicineReminder_id_seq" OWNED BY public.med_reminder.med_id;


--
-- Name: recommendations; Type: TABLE; Schema: public; Owner: malerie
--

CREATE TABLE public.recommendations (
    recommend_id integer NOT NULL,
    recommendations character varying NOT NULL
);


ALTER TABLE public.recommendations OWNER TO malerie;

--
-- Name: recommendations_recommend_id_seq; Type: SEQUENCE; Schema: public; Owner: malerie
--

CREATE SEQUENCE public.recommendations_recommend_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.recommendations_recommend_id_seq OWNER TO malerie;

--
-- Name: recommendations_recommend_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: malerie
--

ALTER SEQUENCE public.recommendations_recommend_id_seq OWNED BY public.recommendations.recommend_id;


--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO postgres;

--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- Name: users_user_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_user_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: doctor dr_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor ALTER COLUMN dr_id SET DEFAULT nextval('public.doctor_id_seq'::regclass);


--
-- Name: med_reminder med_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.med_reminder ALTER COLUMN med_id SET DEFAULT nextval('public."medicineReminder_id_seq"'::regclass);


--
-- Data for Name: doctor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.doctor (user_id, first_name, last_name, email, password, is_doctor, dr_id, "medLicenseNum", specialization, "patientList") FROM stdin;
\.
COPY public.doctor (user_id, first_name, last_name, email, password, is_doctor, dr_id, "medLicenseNum", specialization, "patientList") FROM '$$PATH$$/3624.dat';

--
-- Data for Name: health_data; Type: TABLE DATA; Schema: public; Owner: malerie
--

COPY public.health_data (health_id, user_id, gender, age, weight, height, rest_heart_rate, active_heart_rate, blood_pressure, blood_sugar, steps, cardio_minutes, hours_slept, date, med_list, allergies, med_history, dr_id) FROM stdin;
\.
COPY public.health_data (health_id, user_id, gender, age, weight, height, rest_heart_rate, active_heart_rate, blood_pressure, blood_sugar, steps, cardio_minutes, hours_slept, date, med_list, allergies, med_history, dr_id) FROM '$$PATH$$/3628.dat';

--
-- Data for Name: med_reminder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.med_reminder (med_id, user_id, med_name, dosage, schedule, start_date, end_date) FROM stdin;
\.
COPY public.med_reminder (med_id, user_id, med_name, dosage, schedule, start_date, end_date) FROM '$$PATH$$/3626.dat';

--
-- Data for Name: recommendations; Type: TABLE DATA; Schema: public; Owner: malerie
--

COPY public.recommendations (recommend_id, recommendations) FROM stdin;
\.
COPY public.recommendations (recommend_id, recommendations) FROM '$$PATH$$/3630.dat';

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, first_name, last_name, email, password, is_doctor) FROM stdin;
\.
COPY public.users (user_id, first_name, last_name, email, password, is_doctor) FROM '$$PATH$$/3622.dat';

--
-- Name: doctor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.doctor_id_seq', 1, false);


--
-- Name: medicineReminder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."medicineReminder_id_seq"', 1, false);


--
-- Name: recommendations_recommend_id_seq; Type: SEQUENCE SET; Schema: public; Owner: malerie
--

SELECT pg_catalog.setval('public.recommendations_recommend_id_seq', 1, false);


--
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);


--
-- Name: users_user_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq1', 25, true);


--
-- Name: doctor doctor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (dr_id);


--
-- Name: health_data healthData_pkey; Type: CONSTRAINT; Schema: public; Owner: malerie
--

ALTER TABLE ONLY public.health_data
    ADD CONSTRAINT "healthData_pkey" PRIMARY KEY (health_id);


--
-- Name: med_reminder id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.med_reminder
    ADD CONSTRAINT id PRIMARY KEY (med_id);


--
-- Name: recommendations recommendations_pkey; Type: CONSTRAINT; Schema: public; Owner: malerie
--

ALTER TABLE ONLY public.recommendations
    ADD CONSTRAINT recommendations_pkey PRIMARY KEY (recommend_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: fki_user_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_id ON public.doctor USING btree (user_id);


--
-- Name: med_reminder user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.med_reminder
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON UPDATE CASCADE;


--
-- Name: doctor user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 