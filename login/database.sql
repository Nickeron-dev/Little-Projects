PGDMP     /                    y        	   login-app    13.2    13.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25005 	   login-app    DATABASE     o   CREATE DATABASE "login-app" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "login-app";
                postgres    false            �            1259    25045    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    username text NOT NULL,
    email text NOT NULL,
    password text NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    25043    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000
    CACHE 1
);
            public          postgres    false    201            �          0    25045    users 
   TABLE DATA           >   COPY public.users (id, username, email, password) FROM stdin;
    public          postgres    false    201   f       �           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 35, true);
          public          postgres    false    200            $           2606    25052    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    201            �   �  x�]�Ks�0��͏q���-�Ժ�-;I���"�hW�������_z�=I(á|���v!ޕ���4Mr<W#��6[�I��1܂C+� ��w����;���"ϋZ6%�m�uC�����jp&1m�����.g�&+�=����h�ig)7w�%��Ǻv�$��V�9��kE{�K1�J�	��饤�� ��
�δ	^�}�J��w/>F�09G�n�r]l����G�~���o�B��i`�9Rv�'Zr�Xo=/v�ǿ��Y���^�<œ��5����"5��F�=	��q���yd��L�Ǜ�c/�n�J���+�ڕCi��ǡr4����"�|ߏ8��cg��Vɏs5ؔ(���@����f������.�z�S��7-�ͣ�d�gx�M7�b���^��nG�#���� �H�~�^Y"^��o�O�� Y^HD5)�<O��s]��$b��]�$����     