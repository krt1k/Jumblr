use jumblr;
desc words;
-- drop table words;

create table words(
levelNo INT, 
    word VARCHAR(100));
    
-- Level 1 words (easy, 3 letters, difficulty: 1%)
INSERT INTO words (levelNo, word) VALUES
    (1, 'cat'),
    (1, 'dog'),
    (1, 'man'),
    (1, 'pen'),
    (1, 'car'),
    (1, 'cup'),
    (1, 'map'),
    (1, 'fox'),
    (1, 'sun'),
    (1, 'sky');

-- Level 2 words (3 letters, difficulty: 1.3%)
INSERT INTO words (levelNo, word) VALUES
    (2, 'bar'),
    (2, 'bed'),
    (2, 'cow'),
    (2, 'day'),
    (2, 'egg'),
    (2, 'fly'),
    (2, 'hat'),
    (2, 'ice'),
    (2, 'joy'),
    (2, 'key');

-- Level 3 words (4 letters, difficulty: 1.7%)
INSERT INTO words (levelNo, word) VALUES
    (3, 'cake'),
    (3, 'desk'),
    (3, 'fire'),
    (3, 'girl'),
    (3, 'hand'),
    (3, 'jazz'),
    (3, 'kite'),
    (3, 'lamp'),
    (3, 'milk'),
    (3, 'note');
    
    
select * from words;

-- Level 4 words (4 letters, difficulty: 2%)
INSERT INTO words (levelNo, word) VALUES
    (4, 'beef'),
    (4, 'clap'),
    (4, 'duck'),
    (4, 'fern'),
    (4, 'goat'),
    (4, 'harp'),
    (4, 'itch'),
    (4, 'junk'),
    (4, 'knob'),
    (4, 'luck');

-- Level 5 words (5 letters, difficulty: 2.3%)
INSERT INTO words (levelNo, word) VALUES
    (5, 'apple'),
    (5, 'brown'),
    (5, 'cloud'),
    (5, 'dance'),
    (5, 'earth'),
    (5, 'fable'),
    (5, 'grape'),
    (5, 'house'),
    (5, 'ivory'),
    (5, 'juice');

select * from words;
-- Level 6 words (5 letters, difficulty: 2.7%)
INSERT INTO words (levelNo, word) VALUES
    (6, 'baker'),
    (6, 'chess'),
    (6, 'daisy'),
    (6, 'eagle'),
    (6, 'frail'),
    (6, 'gloom'),
    (6, 'hedge'),
    (6, 'insect'),
    (6, 'jolly'),
    (6, 'knack');

-- Level 7 words (6 letters, difficulty: 3%)
INSERT INTO words (levelNo, word) VALUES
    (7, 'banana'),
    (7, 'coffee'),
    (7, 'dancer'),
    (7, 'eclipse'),
    (7, 'flower'),
    (7, 'garden'),
    (7, 'hollow'),
    (7, 'island'),
    (7, 'jacket'),
    (7, 'kindly');

-- Level 8 words (7 letters, difficulty: 3.3%)
INSERT INTO words (levelNo, word) VALUES
    (8, 'chicken'),
    (8, 'dolphin'),
    (8, 'elephant'),
    (8, 'fashion'),
    (8, 'garbage'),
    (8, 'hamster'),
    (8, 'imagine'),
    (8, 'jungle'),
    (8, 'kitchen'),
    (8, 'library');

select * from words;
-- Level 9 words (7 letters, difficulty: 3.7%)
INSERT INTO words (levelNo, word) VALUES
    (9, 'business'),
    (9, 'computer'),
    (9, 'dinosaur'),
    (9, 'eleven'),
    (9, 'firefly'),
    (9, 'giraffe'),
    (9, 'hospital'),
    (9, 'inquire'),
    (9, 'journal'),
    (9, 'kangaroo');

-- Level 10 words (8 letters, difficulty: 4%)
INSERT INTO words (levelNo, word) VALUES
    (10, 'champion'),
    (10, 'delicate'),
    (10, 'elephant'),
    (10, 'fantastic'),
    (10, 'gorgeous'),
    (10, 'happiness'),
    (10, 'identify'),
    (10, 'jubilant'),
    (10, 'knowledge'),
    (10, 'lifestyle');

-- Level 11 words (8 letters, difficulty: 4.5%)
INSERT INTO words (levelNo, word) VALUES
    (11, 'beautiful'),
    (11, 'concerned'),
    (11, 'destination'),
    (11, 'enthusiasm'),
    (11, 'fascinate'),
    (11, 'government'),
    (11, 'horoscope'),
    (11, 'inspector'),
    (11, 'juxtapose'),
    (11, 'knowledge');

-- Level 12 words (9 letters, difficulty: 5%)
INSERT INTO words (levelNo, word) VALUES
    (12, 'absurdity'),
    (12, 'benevolent'),
    (12, 'contemplate'),
    (12, 'determination'),
    (12, 'eclectic'),
    (12, 'familiarity'),
    (12, 'gullibility'),
    (12, 'hypothesis'),
    (12, 'independent'),
    (12, 'juxtapose');

-- Level 13 words (9 letters, difficulty: 5.5%)
INSERT INTO words (levelNo, word) VALUES
    (13, 'bureaucrat'),
    (13, 'camaraderie'),
    (13, 'deliberate'),
    (13, 'elaboration'),
    (13, 'fascinating'),
    (13, 'gratifying'),
    (13, 'hypothetical'),
    (13, 'inquisitive'),
    (13, 'juxtaposition'),
    (13, 'kindergarten');

-- Level 14 words (10 letters, difficulty: 6%)
INSERT INTO words (levelNo, word) VALUES
    (14, 'accidentally'),
    (14, 'bureaucracy'),
    (14, 'corporation'),
    (14, 'destruction'),
    (14, 'exhilarating'),
    (14, 'frustration'),
    (14, 'grandfather'),
    (14, 'hypothesis'),
    (14, 'investigate'),
    (14, 'juxtapose');

-- Level 15 words (11 letters, difficulty: 6.5%)
INSERT INTO words (levelNo, word) VALUES
    (15, 'accomplished'),
    (15, 'bureaucratic'),
    (15, 'disappointed'),
    (15, 'entertainment'),
    (15, 'fundamental'),
    (15, 'hypothesize'),
    (15, 'independence'),
    (15, 'juxtaposition'),
    (15, 'knowledgeable'),
    (15, 'lexicography');

-- Level 16 words (11 letters, difficulty: 7%)
INSERT INTO words (levelNo, word) VALUES
    (16, 'authoritative'),
    (16, 'bureaucratize'),
    (16, 'circumstance'),
    (16, 'disappearance'),
    (16, 'entrepreneur'),
    (16, 'heterogeneous'),
    (16, 'improvisation'),
    (16, 'juxtaposition'),
    (16, 'kaleidoscope'),
    (16, 'lexicography');

-- Level 17 words (12 letters, difficulty: 7.5%)
INSERT INTO words (levelNo, word) VALUES
    (17, 'acknowledgment'),
    (17, 'bureaucratical'),
    (17, 'circumlocution'),
    (17, 'disappointment'),
    (17, 'entrepreneurial'),
    (17, 'heterosexuality'),
    (17, 'impressionable'),
    (17, 'juxtapositions'),
    (17, 'knowledgeable'),
    (17, 'lexicographers');

-- Level 18 words (12 letters, difficulty: 8%)
INSERT INTO words (levelNo, word) VALUES
    (18, 'accommodation'),
    (18, 'bureaucratized'),
    (18, 'circumspection'),
    (18, 'disapprobation'),
    (18, 'extravagantly'),
    (18, 'hypersensitive'),
    (18, 'impracticable'),
    (18, 'juxtapositions'),
    (18, 'knowledgeably'),
    (18, 'lexicographic');

-- Level 19 words (13 letters, difficulty: 8.5%)
INSERT INTO words (levelNo, word) VALUES
    (19, 'accomplishment'),
    (19, 'bureaucratised'),
    (19, 'circumnavigate'),
    (19, 'disapprovingly'),
    (19, 'extraordinarily'),
    (19, 'hyperventilate'),
    (19, 'improvisations'),
    (19, 'juxtapositional'),
    (19, 'knowledgeables'),
    (19, 'lexicographical');

-- Level 20 words (13 letters, difficulty: 9%)
INSERT INTO words (levelNo, word) VALUES
    (20, 'accountability'),
    (20, 'bureaucratizing'),
    (20, 'circumambulated'),
    (20, 'discombobulated'),
    (20, 'extracurricular'),
    (20, 'hypervigilance'),
    (20, 'impressionistic'),
    (20, 'juxtapositioning'),
    (20, 'knowledgeability'),
    (20, 'lexicographically');
    
    
select * from words;
