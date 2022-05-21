INSERT INTO public.applicationuser(
	applicationuser_id, is_accountnonexpired, is_accountnonlocked, is_credentialsnonexpired, is_enabled, password, user_name, role_name)
	VALUES (nextval('application_sequence'), 1, 1, 1, 1, '$2a$10$coNKFNUhkEUCRBaU7tewSO8OXZwDE5CDf4mwiGHgAcVXG88E6o5mK', 'suharbramar', 'ADMIN');

INSERT INTO public.applicationuser(
	applicationuser_id, is_accountnonexpired, is_accountnonlocked, is_credentialsnonexpired, is_enabled, password, user_name, role_name)
	VALUES (nextval('application_sequence'), 1, 1, 1, 1, '$2a$10$TwBOwx1dTe.c4Vv36.Od6ecOHQqXKb9PEoAgzQIGgyezwyjaIZZ6a', 'budi', 'STAFF');

--$2a$10$TwBOwx1dTe.c4Vv36.Od6ecOHQqXKb9PEoAgzQIGgyezwyjaIZZ6a
update public.applicationuser set user_name ='suharbramar' where applicationuser_id = 2;

select * from applicationuser;


INSERT INTO public.userrole(role_id,
	role_name, role_description, is_role_enabled)
	VALUES (1, 'ADMIN', 'ADMIN ROLE', 1);

INSERT INTO public.userrole(role_id,
	role_name, role_description, is_role_enabled)
	VALUES (2, 'STAFF', 'STAFF ROLE', 1);
	
select * from userrole;

INSERT INTO public.userpermission(permission_id,role_name,
	permission_name, is_permission_enabled)
	VALUES (1,'ADMIN','category:read', 1);

INSERT INTO public.userpermission(permission_id,role_name,
	permission_name, is_permission_enabled)
	VALUES (2,'ADMIN','category:write', 1);

INSERT INTO public.userpermission(permission_id,role_name,
	permission_name, is_permission_enabled)
	VALUES (3,'ADMIN','category:delete', 1);

INSERT INTO public.userpermission(permission_id,role_name,
	permission_name, is_permission_enabled)
	VALUES (4,'STAFF','category:read', 1);



INSERT INTO public.userpermission(
	permission_name, is_permission_enabled)
	VALUES ('category:delete', 1);

select * from public.userpermission;

--rolename --permissionname --enabled 
--admin     --category-read
--admin