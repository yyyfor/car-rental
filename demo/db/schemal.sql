create table car
(
    id             bigint auto_increment comment 'primary key id'
        primary key,
    brand          varchar(100)                       not null comment 'the brand of the car',
    model          varchar(100)                       not null comment 'the model of the car',
    price_per_hour decimal(10, 2)                     null comment 'the price for rent car for one hour',
    create_time    datetime default CURRENT_TIMESTAMP not null comment 'the create time of the car',
    update_time    datetime                           null on update CURRENT_TIMESTAMP comment 'the update time of the car'
)
    comment 'car information' collate = utf8mb4_unicode_ci;

create table booking
(
    id          bigint auto_increment comment 'primary key'
        primary key,
    user_id     bigint                             not null comment 'the user id',
    car_id      bigint                             not null comment 'the car id',
    start_time  datetime                           not null comment 'the start time of the order',
    end_time    datetime                           not null comment 'the end time of the order',
    create_time datetime default CURRENT_TIMESTAMP not null comment 'the create time of the order',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment 'update time of the order'
)
    comment 'booking table' collate = utf8mb4_unicode_ci;

create table user
(
    id          bigint auto_increment comment 'primary key id'
        primary key,
    name        varchar(100)                       not null comment 'user name',
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime                           null on update CURRENT_TIMESTAMP
)
    comment 'user table' collate = utf8mb4_unicode_ci;

