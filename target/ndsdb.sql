PGDMP      0                }            ndsdb    16.4    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    54250    ndsdb    DATABASE     |   CREATE DATABASE ndsdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';
    DROP DATABASE ndsdb;
                postgres    false            �            1259    62593    accounts    TABLE     )  CREATE TABLE public.accounts (
    account_id character varying(255) NOT NULL,
    user_id character varying(255) NOT NULL,
    balance integer DEFAULT 0,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.accounts;
       public         heap    postgres    false            �            1259    62608    transactions    TABLE       CREATE TABLE public.transactions (
    transaction_id character varying(255) NOT NULL,
    account_id character varying(255) NOT NULL,
    type character varying(20) NOT NULL,
    amount integer NOT NULL,
    "timestamp" timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
     DROP TABLE public.transactions;
       public         heap    postgres    false            �            1259    62584    users    TABLE     Z  CREATE TABLE public.users (
    user_id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.users;
       public         heap    postgres    false            �          0    62593    accounts 
   TABLE DATA           X   COPY public.accounts (account_id, user_id, balance, created_at, updated_at) FROM stdin;
    public          postgres    false    216   k       �          0    62608    transactions 
   TABLE DATA           ]   COPY public.transactions (transaction_id, account_id, type, amount, "timestamp") FROM stdin;
    public          postgres    false    217          �          0    62584    users 
   TABLE DATA           W   COPY public.users (user_id, name, password, email, created_at, updated_at) FROM stdin;
    public          postgres    false    215   �       `           2606    62602    accounts accounts_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (account_id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    216            b           2606    62615    transactions transactions_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);
 H   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_pkey;
       public            postgres    false    217            ^           2606    62592    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    215            c           2606    62603    accounts accounts_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_user_id_fkey;
       public          postgres    false    216    4702    215            d           2606    62616 )   transactions transactions_account_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.accounts(account_id) ON DELETE CASCADE;
 S   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_account_id_fkey;
       public          postgres    false    4704    216    217            �   �   x�����0kk�,@�Q�=D&p#Jb�� �$��=��w�۔9���XݸC��&���Pk[����z�Ux���Zk�!���
(�v��$?�؅��>����-� C^_A���0��?J�㩾Wgݮ{�ߊ���^JyJ Vo      �   �   x��ͽ�0@�ڞ��ӏe+)!)h9J	��G ������l*�@��a`�+�ʜMǧZ��d*�uh�
���M�b<�Xُ��^�0�
�8�1m,��s�=�ܾ�WNp�U��F'�O�܎�'��VK���,5|      �   l   x�}�9�0@��>k3`W��S�!f@�X$"�����O��F5a�B$�eQ�'+�&U��=�����Y?n�����:�6�5�cs��
`�`��eN!i"������ $     