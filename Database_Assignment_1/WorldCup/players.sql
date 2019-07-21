create table players(
player_id INT NOT NULL,
team_id INT NOT NULL,
name varchar(256) NOT NULL,
skill varchar(256) NOT NULL CHECK (skill IN ('batsman','bowler','allrounder')),
score INT,
wickets INT,
primary key(player_id,team_id)
);
ALTER TABLE players
ADD FOREIGN KEY (team_id) REFERENCES team(team_id);
