create table player_performance(    
tournament_id INT NOT NULL,    
match_id INT NOT NULL,    
player_id INT NOT NULL,    
score INT,    
wickets INT,    
team_id INT NOT NULL,
primary key(tournament_id,match_id,player_id,team_id) 
);
ALTER TABLE player_performance
ADD FOREIGN KEY (player_id) REFERENCES players(player_id);
ALTER TABLE player_performance
ADD FOREIGN KEY (team_id) REFERENCES team(team_id);

