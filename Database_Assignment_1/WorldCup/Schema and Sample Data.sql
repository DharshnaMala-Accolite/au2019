create database worldcup;
use worldcup;
create table team (
	team_id int not null,
	country varchar(256),
	tournament_win int,
	primary key (team_id)
);
insert into team values(1,"india",2);
insert into team values(2,"south africa",0);
insert into team values(3,"england",1);
insert into team values(4,"new zealand",0);
insert into team values(5,"west indies",2);
select * from team;


create table team_performance(
   tournament_id INT NOT NULL,
   match_id INT NOT NULL,
   team_id INT NOT NULL,
   score INT,
   wickets INT,
   status varchar(256) NOT NULL CHECK (status IN ('won','lost','draw')),
   primary key(tournament_id,match_id,team_id)
);
ALTER TABLE team_performance ADD FOREIGN KEY (team_id) REFERENCES team(team_id);

insert into team_performance values(2019,1,1,250,8,"won");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,2,4,250,8 ,"lost");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,2,3,251,6,"won");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,3,5,278,5,"won");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,3 ,2,200,10,"lost");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,4 ,1,350,5,"won");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,4,5,203,10,"lost");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,5 ,5,324,7,"won");
Insert into team_performance(tournament_id,match_id,team_id,score,wickets,status) Values(2019,5 ,4,250,8,"lost");
 select * from team_performance;
 
create table players(
player_id INT NOT NULL,
team_id INT NOT NULL,
name varchar(256) NOT NULL,
skill varchar(256) NOT NULL CHECK (skill IN ('batsman','bowler','allrounder')),
score INT,
wickets INT,
primary key(player_id,team_id)
);
ALTER TABLE players ADD FOREIGN KEY (team_id) REFERENCES team(team_id);
insert into players values(7,1,"ms dhoni","batsman","5000",2);
insert into players values(11,1,"kholi","batsman","8000",2);
insert into players values(3,1,"bumrah","bowler","100",100);
insert into players values(17,1,"jadeja","bowler","500",80);
insert into players values(18,1,"bhuvaneshwar","bowler","50",90);
insert into players values(7,2,"faf","batsman","5000",2);
insert into players values(11,2,"duminy","batsman","8000",2);
insert into players values(3,2,"tahir","bowler","100",100);
insert into players values(17,2,"steyn","bowler","500",80);
insert into players values(18,2,"devillers","batsman","5000",0);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(23,4,"Kane","batsman",4598,2);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(25,3,"root","batsman",6789,10);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(26,3,"buttler","batsman",3488,0);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(24,4,"boult","bowler",450,27);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(30,5,"gayle","batsman",6570,24);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(31,3,"stokes","allrounder",4678,30);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(32,5,"holder","bowler",2399,70);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(37,3,"ali","allrounder",5643,58);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(38,1,"dhawan","batsman",8000,0);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(39,2,"shamsi","batsman",3211,23);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(40,4,"henry","bowler",123,89);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(41,4,"guptill","batsman",7570,0);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(42,5,"cottrell","bowler",34,40);
Insert into players(player_id,team_id,name,skill,score,wickets) Values(43,3,"morgan","batsman",9876,0); 
Insert into players(player_id,team_id,name,skill,score,wickets) Values(44,3,"roy","batsman",6678,0);

select * from players;

create table player_performance(    
tournament_id INT NOT NULL,    
match_id INT NOT NULL,    
player_id INT NOT NULL,    
score INT,    
wickets INT,    
team_id INT NOT NULL,
primary key(tournament_id,match_id,player_id,team_id) 
);
ALTER TABLE player_performance ADD FOREIGN KEY (player_id) REFERENCES players(player_id);
ALTER TABLE player_performance ADD FOREIGN KEY (team_id) REFERENCES team(team_id);

insert into player_performance (tournament_id,    match_id ,    team_id,player_id,    score,    
wickets) values(2019,1,1,7,85,0);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,2,23,4,100,0);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,2,25,3,120,1);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,2,26,3,50,0);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,2,24,4,2,5);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,3,30,5,28,2);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,3,39,2,21,3);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,4,38,1,123,0);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,4,42,5,1,4);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,5,30,5,78,3);
Insert into player_performance(tournament_id,match_id,player_id,team_id,score,wickets) Values(2019,5,23,4,56,0);
 select * from player_performance;

 