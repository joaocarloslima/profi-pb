-- Locais (locations)
INSERT INTO location (id, city, state, neighborhood, created_at, updated_at)
VALUES
    (1, 'São Paulo', 'SP', 'Vila Mariana', NOW(), NOW()),
    (2, 'São Paulo', 'SP', 'Pinheiros', NOW(), NOW()),
    (3, 'Rio de Janeiro', 'RJ', 'Copacabana', NOW(), NOW()),
    (4, 'Rio de Janeiro', 'RJ', 'Ipanema', NOW(), NOW()),
    (5, 'Belo Horizonte', 'MG', 'Savassi', NOW(), NOW());

-- Categorias (category)
INSERT INTO category (id, name, created_at, updated_at)
VALUES
    (1, 'Eletricista', NOW(), NOW()),
    (2, 'Encanador', NOW(), NOW()),
    (3, 'Pintor', NOW(), NOW()),
    (4, 'Carpinteiro', NOW(), NOW());

-- Profissionais
INSERT INTO professional (id, name, email, phone, location_id, created_at, updated_at)
VALUES
    (1, 'João Silva', 'joao.silva@example.com', '11999990000', 1, NOW(), NOW()),
    (2, 'Maria Souza', 'maria.souza@example.com', '11988880000', 1, NOW(), NOW()),
    (3, 'Pedro Lima', 'pedro.lima@example.com', '21977770000', 3, NOW(), NOW()),
    (4, 'Ana Costa', 'ana.costa@example.com', '21966660000', 4, NOW(), NOW()),
    (5, 'Carla Rocha', 'carla.rocha@example.com', '31955550000', 5, NOW(), NOW()),
    (6, 'Lucas Pereira', 'lucas.pereira@example.com', '11977770000', 1, NOW(), NOW()),
    (7, 'Fernanda Lima', 'fernanda.lima@example.com', '11966660000', 2, NOW(), NOW());

-- Associação profissional ↔ categoria (join table)
INSERT INTO professional_category (professional_id, category_id)
VALUES
    (1, 1),  -- João Silva é Eletricista
    (1, 3),  -- João Silva também Pintor
    (2, 2),  -- Maria Souza é Encanador
    (2, 3),  -- Maria Souza também pintora
    (3, 1),  -- Pedro Lima eletricista
    (4, 3),  -- Ana Costa pintora
    (5, 1),  -- Carla Rocha eletricista
    (5, 2),  -- Carla Rocha encanadora
    (6, 1),  -- Lucas Pereira eletricista
    (6, 4),  -- Lucas Pereira carpinteiro
    (7, 2),  -- Fernanda Lima encanadora
    (7, 3);  -- Fernanda Lima pintora