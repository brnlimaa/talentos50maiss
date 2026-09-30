INSERT INTO categorias (nome, descricao) VALUES
    ('Artesanato', 'Peças artesanais e trabalhos manuais'),
    ('Aulas', 'Aulas particulares e compartilhamento de conhecimentos'),
    ('Consertos', 'Pequenos reparos e manutenção'),
    ('Costura', 'Ajustes, reparos e confecção de roupas'),
    ('Culinária', 'Comidas, bolos e serviços culinários'),
    ('Jardinagem', 'Cuidados com plantas e jardins')
ON CONFLICT (nome) DO NOTHING;