-- CREATE DATABASE db_parkirin
-- if u doesn't have it

INSERT INTO public.area (area_id, parking_area) VALUES (1, 'Field A');
INSERT INTO public.area (area_id, parking_area) VALUES (2, 'Field B');
INSERT INTO public.area (area_id, parking_area) VALUES (3, 'Field C');
INSERT INTO public.area (area_id, parking_area) VALUES (4, 'Field D');

INSERT INTO public.brand (brand_id, vehicle_brand) VALUES (1, 'Mazda');
INSERT INTO public.brand (brand_id, vehicle_brand) VALUES (2, 'Honda');
INSERT INTO public.brand (brand_id, vehicle_brand) VALUES (3, 'BWM');

INSERT INTO public.dtl_parking (parking_id, duration, parking_date_start, parking_price_id, vehicle_id) VALUES (1, 3, '2022-12-01', 1, 1);
INSERT INTO public.dtl_parking (parking_id, duration, parking_date_start, parking_price_id, vehicle_id) VALUES (2, 3, '2022-12-01', 3, 2);
INSERT INTO public.dtl_parking (parking_id, duration, parking_date_start, parking_price_id, vehicle_id) VALUES (3, 7, '2022-08-08', 2, 1);


INSERT INTO public.dtl_vehicle (dtl_vehicle_id, owner_id, vehicle_id, color) VALUES (1, 1, 1, 'Hitam');
INSERT INTO public.dtl_vehicle (dtl_vehicle_id, owner_id, vehicle_id, color) VALUES (2, 2, 4, 'Hitam');


INSERT INTO public.owner (owner_id, owner_name, phone) VALUES (1, 'Bagus Miftaq', '081234567890');
INSERT INTO public.owner (owner_id, owner_name, phone) VALUES (2, 'Abiza Robbiul', '081234567000');

INSERT INTO public.parking_out (paking_out_id, discount, fine, parking_date_take, parking_id) VALUES (1, 10, 0, '2022-12-01', 1);
INSERT INTO public.parking_out (paking_out_id, discount, fine, parking_date_take, parking_id) VALUES (2, 0, 10, '2022-12-05', 2);
INSERT INTO public.parking_out (paking_out_id, discount, fine, parking_date_take, parking_id) VALUES (3, 0, 5, '2022-08-16', 3);

INSERT INTO public.parking_price (parking_price_id, is_active, price, parking_type_id) VALUES (1, true, 20000, 1);
INSERT INTO public.parking_price (parking_price_id, is_active, price, parking_type_id) VALUES (2, true, 15000, 2);
INSERT INTO public.parking_price (parking_price_id, is_active, price, parking_type_id) VALUES (3, true, 10000, 3);
INSERT INTO public.parking_price (parking_price_id, is_active, price, parking_type_id) VALUES (4, true, 5000, 4);


INSERT INTO public.parking_type (parking_type_id, status, parking_type_variant, area_id) VALUES (1, true, 'Ultra', 1);
INSERT INTO public.parking_type (parking_type_id, status, parking_type_variant, area_id) VALUES (2, true, 'High', 2);
INSERT INTO public.parking_type (parking_type_id, status, parking_type_variant, area_id) VALUES (3, true, 'Mid', 3);
INSERT INTO public.parking_type (parking_type_id, status, parking_type_variant, area_id) VALUES (4, true, 'Low', 4);

INSERT INTO public.type (vehicle_id, vehicle_type) VALUES (1, 'Mobil');

INSERT INTO public.vehicle (vehicle_id, number_plate, brand_id, type_id) VALUES (1, 'BE 8750 JK', 1, 1);
INSERT INTO public.vehicle (vehicle_id, number_plate, brand_id, type_id) VALUES (4, 'BE 1290 ZX', 2, 1);
