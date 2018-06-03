/**
* V1__init - Initial version of websystem database.
*
*/

COMMENT ON DATABASE websystem IS 'Database of for Websystems developed by Maxigênios.';

CREATE TABLE public.auth_group (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    name character varying(80) NOT NULL
);

ALTER TABLE public.auth_group OWNER TO postgres;

COMMENT ON TABLE public.auth_group IS 'Authorization Group table.';
COMMENT ON COLUMN public.auth_group.id IS 'Id of Group Authorization.';
COMMENT ON COLUMN public.auth_group.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.auth_group.name IS 'Name of the Authorization Group.';

CREATE SEQUENCE public.auth_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.auth_group_id_seq OWNER TO postgres;

ALTER SEQUENCE public.auth_group_id_seq OWNED BY public.auth_group.id;

COMMENT ON SEQUENCE public.auth_group_id_seq IS 'Sequence for auth_group table.';

CREATE TABLE public.auth_group_permissions (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    group_id integer NOT NULL,
    permission_id integer NOT NULL
);

ALTER TABLE public.auth_group_permissions OWNER TO postgres;

COMMENT ON TABLE public.auth_group_permissions IS 'Authorization Group x Permissions Table. (MxM table)';
COMMENT ON COLUMN public.auth_group_permissions.id IS 'Id of Auth Group Permissions.';
COMMENT ON COLUMN public.auth_group_permissions.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.auth_group_permissions.group_id IS 'Id of Auth Group Table (FK).';
COMMENT ON COLUMN public.auth_group_permissions.permission_id IS 'Id of Auth Permission Table (FK).';

CREATE SEQUENCE public.auth_group_permissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.auth_group_permissions_id_seq OWNER TO postgres;

ALTER SEQUENCE public.auth_group_permissions_id_seq OWNED BY public.auth_group_permissions.id;

COMMENT ON SEQUENCE public.auth_group_permissions_id_seq IS 'Sequence for auth_group_permissions table.';

CREATE TABLE public.auth_permission (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    name character varying(255) NOT NULL,
    content_type_id integer NOT NULL,
    codename character varying(100) NOT NULL
);

ALTER TABLE public.auth_permission OWNER TO postgres;

COMMENT ON TABLE public.auth_permission IS 'Authorization Permission table.';
COMMENT ON COLUMN public.auth_permission.id IS 'Id of Authorization Permission.';
COMMENT ON COLUMN public.auth_permission.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.auth_permission.name IS 'Name of the Authorization Permission.';

CREATE SEQUENCE public.auth_permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.auth_permission_id_seq OWNER TO postgres;

ALTER SEQUENCE public.auth_permission_id_seq OWNED BY public.auth_permission.id;

COMMENT ON SEQUENCE public.auth_permission_id_seq IS 'Sequence for auth_permission table.';

CREATE TABLE public.auth_user (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    password character varying(128) NOT NULL,
    last_login timestamp with time zone,
    is_superuser boolean NOT NULL,
    username character varying(30) NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    email character varying(254) NOT NULL,
    is_staff boolean NOT NULL,
    is_active boolean NOT NULL,
    date_joined timestamp with time zone NOT NULL
);

ALTER TABLE public.auth_user OWNER TO postgres;

COMMENT ON TABLE public.auth_user IS 'Authorization User table.';
COMMENT ON COLUMN public.auth_user.id IS 'Id of User Authorization.';
COMMENT ON COLUMN public.auth_user.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.auth_user.password IS 'Encrypted Password.';
COMMENT ON COLUMN public.auth_user.last_login IS 'Date/Time of last login.';
COMMENT ON COLUMN public.auth_user.is_superuser IS 'Is a super_user / admin ?';
COMMENT ON COLUMN public.auth_user.username IS 'Username.';
COMMENT ON COLUMN public.auth_user.first_name IS 'First Name of the User.';
COMMENT ON COLUMN public.auth_user.last_name IS 'Last Name of the User.';
COMMENT ON COLUMN public.auth_user.email IS 'E-mail of the User.';
COMMENT ON COLUMN public.auth_user.is_staff IS 'Is staff of the user ?';
COMMENT ON COLUMN public.auth_user.is_active IS 'Is active ?';
COMMENT ON COLUMN public.auth_user.date_joined IS 'Date/Time of the joined.';

CREATE TABLE public.auth_user_groups (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    user_id integer NOT NULL,
    group_id integer NOT NULL
);

ALTER TABLE public.auth_user_groups OWNER TO postgres;

COMMENT ON TABLE public.auth_user_groups IS 'Authorization User x Authorization Group Table. (MxM table)';
COMMENT ON COLUMN public.auth_user_groups.id IS 'Id of Auth User Group Authorization.';
COMMENT ON COLUMN public.auth_user_groups.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.auth_user_groups.user_id IS 'Id of Auth User Table (FK).';
COMMENT ON COLUMN public.auth_user_groups.group_id IS 'Id of Auth Group Table (FK).';

CREATE SEQUENCE public.auth_user_groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.auth_user_groups_id_seq OWNER TO postgres;

ALTER SEQUENCE public.auth_user_groups_id_seq OWNED BY public.auth_user_groups.id;

COMMENT ON SEQUENCE public.auth_user_groups_id_seq IS 'Sequence for auth_user_groups table.';

CREATE SEQUENCE public.auth_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.auth_user_id_seq OWNER TO postgres;

ALTER SEQUENCE public.auth_user_id_seq OWNED BY public.auth_user.id;

COMMENT ON SEQUENCE public.auth_user_id_seq IS 'Sequence for auth_user table.';

CREATE TABLE public.auth_user_user_permissions (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    user_id integer NOT NULL,
    permission_id integer NOT NULL
);

ALTER TABLE public.auth_user_user_permissions OWNER TO postgres;

COMMENT ON TABLE public.auth_user_user_permissions IS 'Authorization User x Permissions Table. (MxM table)';
COMMENT ON COLUMN public.auth_user_user_permissions.id IS ' Id of Auth User Group Authorization.';
COMMENT ON COLUMN public.auth_user_user_permissions.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.auth_user_user_permissions.user_id IS 'Id of Auth User Table (FK).';
COMMENT ON COLUMN public.auth_user_user_permissions.permission_id IS 'Id of Auth Permission Table (FK).';

CREATE SEQUENCE public.auth_user_user_permissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.auth_user_user_permissions_id_seq OWNER TO postgres;

ALTER SEQUENCE public.auth_user_user_permissions_id_seq OWNED BY public.auth_user_user_permissions.id;

COMMENT ON SEQUENCE public.auth_user_user_permissions_id_seq IS 'Sequence for auth_user_user_permissions table.';

CREATE TABLE public.banner (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    empresa_id integer NOT NULL,
    descricao text NOT NULL,
    link_url character varying(255),
    arquivo character varying(255),
    acao_ao_clicar character varying(255),
    exibir_de timestamp with time zone,
    exibir_ate timestamp with time zone,
    exibir_descricao boolean NOT NULL,
    permite_comentario boolean NOT NULL,
    permitir_compartilhar boolean NOT NULL
);

ALTER TABLE public.banner OWNER TO postgres;

COMMENT ON TABLE public.banner IS 'Banner showed in SlideShow table.';
COMMENT ON COLUMN public.banner.id IS 'Id of Banner.';
COMMENT ON COLUMN public.banner.titulo IS 'Title of Banner.';
COMMENT ON COLUMN public.banner.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.banner.empresa_id IS ' Id of Empresa Table (FK).';
COMMENT ON COLUMN public.banner.descricao IS 'Description of Banner.';
COMMENT ON COLUMN public.banner.link_url IS 'Address of URL/Link of Banner. (External Link)';
COMMENT ON COLUMN public.banner.arquivo IS 'Address of URL/Link of Banner. (Internal Link)';
COMMENT ON COLUMN public.banner.acao_ao_clicar IS 'Action when click.';
COMMENT ON COLUMN public.banner.exibir_de IS 'Show start in Date/Time.';
COMMENT ON COLUMN public.banner.exibir_ate IS 'Show finish in Date/Time.';
COMMENT ON COLUMN public.banner.exibir_descricao IS 'Show description ?';
COMMENT ON COLUMN public.banner.permite_comentario IS 'Can comments ?';
COMMENT ON COLUMN public.banner.permitir_compartilhar IS 'Can share ?';

CREATE SEQUENCE public.banner_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.banner_id_seq OWNER TO postgres;

ALTER SEQUENCE public.banner_id_seq OWNED BY public.banner.id;

COMMENT ON SEQUENCE public.banner_id_seq IS 'Sequence for banner table.';

CREATE TABLE public.categoria_produto (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL
);

ALTER TABLE public.categoria_produto OWNER TO postgres;

COMMENT ON TABLE public.categoria_produto IS 'Category of Product table.';
COMMENT ON COLUMN public.categoria_produto.id IS 'Id of Categoria Produto.';
COMMENT ON COLUMN public.categoria_produto.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.categoria_produto.titulo IS 'Title of Categoria Produto.';
COMMENT ON COLUMN public.categoria_produto.slug IS 'Slug (auto-generated) field.';

CREATE SEQUENCE public.categoria_produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.categoria_produto_id_seq OWNER TO postgres;

ALTER SEQUENCE public.categoria_produto_id_seq OWNED BY public.categoria_produto.id;

COMMENT ON SEQUENCE public.categoria_produto_id_seq IS 'Sequence for categoria_produto table.';

CREATE TABLE public.empresa (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    descricao text NOT NULL,
    data_cadastro timestamp with time zone NOT NULL,
    ativa boolean NOT NULL
);

ALTER TABLE public.empresa OWNER TO postgres;

COMMENT ON TABLE public.empresa IS 'Empresa table.';
COMMENT ON COLUMN public.empresa.id IS 'Id of Empresa.';
COMMENT ON COLUMN public.empresa.titulo IS 'Title of Empresa.';
COMMENT ON COLUMN public.empresa.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.empresa.descricao IS 'Description of Empresa.';
COMMENT ON COLUMN public.empresa.data_cadastro IS 'Date/Time of the joined.';
COMMENT ON COLUMN public.empresa.ativa IS 'Is active ?';

CREATE SEQUENCE public.empresa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.empresa_id_seq OWNER TO postgres;

ALTER SEQUENCE public.empresa_id_seq OWNED BY public.empresa.id;

COMMENT ON SEQUENCE public.empresa_id_seq IS 'Sequence for empresa table.';

CREATE TABLE public.empresa_modulo (
    empresa_id integer NOT NULL,
    modulo_id integer NOT NULL,
    ativo boolean NOT NULL,
    chave_ativacao character varying(255) NOT NULL,
    data_ativacao timestamp with time zone NOT NULL
);

ALTER TABLE public.empresa_modulo OWNER TO postgres;

COMMENT ON TABLE public.empresa_modulo IS 'Empresa X Modules table.';
COMMENT ON COLUMN public.empresa_modulo.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.empresa_modulo.modulo_id IS 'Id of Modulo Table (FK).';
COMMENT ON COLUMN public.empresa_modulo.ativo IS 'Is active ?';
COMMENT ON COLUMN public.empresa_modulo.chave_ativacao IS 'activation key.';
COMMENT ON COLUMN public.empresa_modulo.data_ativacao IS 'Date/Time of activation.';

CREATE TABLE public.endereco (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    tipo_endereco character varying(1) NOT NULL,
    logradouro character varying(255) NOT NULL,
    complemento character varying(255),
    bairro character varying(255) NOT NULL,
    cidade character varying(255) NOT NULL,
    uf character varying(2) NOT NULL,
    cep character varying(10) NOT NULL,
    ponto_referencia character varying(250),
    coordenada_lat character varying(10) NOT NULL,
    coordenada_long character varying(10) NOT NULL,
    fone1 character varying(15) NOT NULL,
    fone2 character varying(15),
    fone1_whathsapp boolean NOT NULL,
    fone2_whathsapp boolean
);

ALTER TABLE public.endereco OWNER TO postgres;

COMMENT ON TABLE public.endereco IS 'Empresa (Address) Table.';
COMMENT ON COLUMN public.endereco.id IS 'Id of Endereco.';
COMMENT ON COLUMN public.endereco.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.endereco.tipo_endereco IS 'Type of Address:

M - Matriz
F - Filial';
COMMENT ON COLUMN public.endereco.logradouro IS 'Logradouro of Address.';
COMMENT ON COLUMN public.endereco.complemento IS 'Complemento of Address.';
COMMENT ON COLUMN public.endereco.bairro IS 'Bairro of Address.';
COMMENT ON COLUMN public.endereco.cidade IS 'City of Address.';
COMMENT ON COLUMN public.endereco.uf IS 'UF of Address.';
COMMENT ON COLUMN public.endereco.cep IS 'CEP of Address.';
COMMENT ON COLUMN public.endereco.ponto_referencia IS 'Refence, tip for the Address.';
COMMENT ON COLUMN public.endereco.coordenada_lat IS 'Lat of Address.';
COMMENT ON COLUMN public.endereco.coordenada_long IS 'Log of Address.';
COMMENT ON COLUMN public.endereco.fone1 IS 'Phone 1. ';
COMMENT ON COLUMN public.endereco.fone2 IS 'Phone 2. ';
COMMENT ON COLUMN public.endereco.fone1_whathsapp IS 'is Whathsapp ?';
COMMENT ON COLUMN public.endereco.fone2_whathsapp IS 'is Whathsapp ?';

CREATE SEQUENCE public.endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.endereco_id_seq OWNER TO postgres;

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;

COMMENT ON SEQUENCE public.endereco_id_seq IS 'Sequence for endereco table.';

CREATE TABLE public.especialidade (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    icone character varying(255) NOT NULL,
    detalhamento text NOT NULL
);

ALTER TABLE public.especialidade OWNER TO postgres;

COMMENT ON TABLE public.especialidade IS 'Specialities table.';
COMMENT ON COLUMN public.especialidade.id IS 'Id of Speciality.';
COMMENT ON COLUMN public.especialidade.empresa_id IS ' Id of Empresa Table (FK).';
COMMENT ON COLUMN public.especialidade.titulo IS 'Title of Speciality.';
COMMENT ON COLUMN public.especialidade.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.especialidade.icone IS ' Address of URL/Link of Icon that represents the  Speciality. (Internal Link)';
COMMENT ON COLUMN public.especialidade.detalhamento IS 'Details of Speciality.';

CREATE SEQUENCE public.especialidade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.especialidade_id_seq OWNER TO postgres;

ALTER SEQUENCE public.especialidade_id_seq OWNED BY public.especialidade.id;

COMMENT ON SEQUENCE public.especialidade_id_seq IS 'Sequence for especialidade table.';

CREATE TABLE public.galeria (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    empresa_id integer NOT NULL,
    descricao text NOT NULL,
    tipo_galeria character varying(1) NOT NULL,
    data_criacao timestamp with time zone NOT NULL,
    data_publicacao timestamp with time zone,
    exibir_de timestamp with time zone,
    exibir_ate timestamp with time zone,
    exibir_descricao boolean NOT NULL,
    permite_comentario boolean NOT NULL,
    permitir_compartilhar boolean NOT NULL
);

ALTER TABLE public.galeria OWNER TO postgres;

COMMENT ON TABLE public.galeria IS 'Gallery (Pictures/Photos or Videos) Table.';
COMMENT ON COLUMN public.galeria.id IS 'Id of Gallery.';
COMMENT ON COLUMN public.galeria.titulo IS 'Title of Gallery.';
COMMENT ON COLUMN public.galeria.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.galeria.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.galeria.descricao IS 'Description of Gallery.';
COMMENT ON COLUMN public.galeria.tipo_galeria IS 'Type of Gallery:

F - Photo
V - Vídeo';
COMMENT ON COLUMN public.galeria.data_criacao IS 'Date/Time of created.';
COMMENT ON COLUMN public.galeria.data_publicacao IS 'Published Date/Time.';
COMMENT ON COLUMN public.galeria.exibir_de IS 'Show start in Date/Time.';
COMMENT ON COLUMN public.galeria.exibir_ate IS 'Show finish in Date/Time.';
COMMENT ON COLUMN public.galeria.exibir_descricao IS 'Show description ?';
COMMENT ON COLUMN public.galeria.permite_comentario IS 'Can comments ?';
COMMENT ON COLUMN public.galeria.permitir_compartilhar IS 'Can share ?';

CREATE SEQUENCE public.galeria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.galeria_id_seq OWNER TO postgres;

ALTER SEQUENCE public.galeria_id_seq OWNED BY public.galeria.id;

COMMENT ON SEQUENCE public.galeria_id_seq IS 'Sequence for galeria table.';

CREATE TABLE public.galeria_midia (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    galeria_id integer NOT NULL,
    link_url character varying(255),
    arquivo character varying(255),
    acao_ao_clicar character varying(255),
    tipo_galeria character varying(1) NOT NULL
);

ALTER TABLE public.galeria_midia OWNER TO postgres;

COMMENT ON TABLE public.galeria_midia IS 'Medias of Gallery Table.';
COMMENT ON COLUMN public.galeria_midia.id IS 'Id of Gallery Media.';
COMMENT ON COLUMN public.galeria_midia.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.galeria_midia.galeria_id IS 'Id of Gallery Table (FK).';
COMMENT ON COLUMN public.galeria_midia.link_url IS ' Address of URL/Link of Media. (External Link)';
COMMENT ON COLUMN public.galeria_midia.arquivo IS 'Address of URL/Link of Media. (Internal Link)';
COMMENT ON COLUMN public.galeria_midia.acao_ao_clicar IS 'Action when click.';
COMMENT ON COLUMN public.galeria_midia.tipo_galeria IS 'Type of Gallery Media:

F - Photo
V - Vídeo';

CREATE SEQUENCE public.galeria_midia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.galeria_midia_id_seq OWNER TO postgres;

ALTER SEQUENCE public.galeria_midia_id_seq OWNED BY public.galeria_midia.id;

COMMENT ON SEQUENCE public.galeria_midia_id_seq IS 'Sequence for galeria_midia table.';

CREATE TABLE public.loggy (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    data_hora timestamp with time zone NOT NULL,
    ip character varying(255) NOT NULL,
    tipo_acao character varying(2) NOT NULL,
    url_acessada character varying(255) NOT NULL,
    usuario_id integer NOT NULL,
    valores_originais character varying(255),
    valores_alterados character varying(255)
);

ALTER TABLE public.loggy OWNER TO postgres;

COMMENT ON TABLE public.loggy IS 'Log of user actions and events occourred in the system Table.';
COMMENT ON COLUMN public.loggy.id IS 'Id of Log.';
COMMENT ON COLUMN public.loggy.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.loggy.data_hora IS 'Date/Time of event/action.';
COMMENT ON COLUMN public.loggy.ip IS 'IP Address of user device.';
COMMENT ON COLUMN public.loggy.tipo_acao IS 'Type of action:

A - Access
I - Insert
U - Update
D - Delete';
COMMENT ON COLUMN public.loggy.url_acessada IS 'Address of current URL/Link.';
COMMENT ON COLUMN public.loggy.usuario_id IS 'Id of Auth User Table. (FK)';
COMMENT ON COLUMN public.loggy.valores_originais IS 'Original values before action/event.';
COMMENT ON COLUMN public.loggy.valores_alterados IS 'Changed values after action/event.';

CREATE SEQUENCE public.loggy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.loggy_id_seq OWNER TO postgres;

ALTER SEQUENCE public.loggy_id_seq OWNED BY public.loggy.id;

COMMENT ON SEQUENCE public.loggy_id_seq IS 'Sequence for loggy table.';

CREATE TABLE public.mensagem (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    assunto character varying(255) NOT NULL,
    remetente character varying(255) NOT NULL,
    email_remetente character varying(255) NOT NULL,
    data_recebimento timestamp with time zone NOT NULL,
    conteudo text NOT NULL,
    respondida boolean NOT NULL
);

ALTER TABLE public.mensagem OWNER TO postgres;

COMMENT ON TABLE public.mensagem IS 'Received Messages Table.';
COMMENT ON COLUMN public.mensagem.id IS 'Id of Message.';
COMMENT ON COLUMN public.mensagem.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.mensagem.assunto IS 'Subject of the message.';
COMMENT ON COLUMN public.mensagem.remetente IS 'Name of Sender.';
COMMENT ON COLUMN public.mensagem.email_remetente IS 'Email of Sender.';
COMMENT ON COLUMN public.mensagem.data_recebimento IS 'Date/Time of received.';
COMMENT ON COLUMN public.mensagem.conteudo IS 'Content of Message.';
COMMENT ON COLUMN public.mensagem.respondida IS 'Is answered ?';

CREATE SEQUENCE public.mensagem_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.mensagem_id_seq OWNER TO postgres;

ALTER SEQUENCE public.mensagem_id_seq OWNED BY public.mensagem.id;

COMMENT ON SEQUENCE public.mensagem_id_seq IS 'Sequence for mensagem table.';

CREATE TABLE public.menu (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    empresa_id integer NOT NULL,
    ordem_exibicao integer NOT NULL,
    nivel_menu integer NOT NULL,
    tipo_publicacao character varying(1) NOT NULL,
    menu_pai_id integer,
    restrito boolean NOT NULL
);

ALTER TABLE public.menu OWNER TO postgres;

COMMENT ON TABLE public.menu IS 'Menu Itens Table.';
COMMENT ON COLUMN public.menu.id IS 'Id of Menu.';
COMMENT ON COLUMN public.menu.titulo IS 'Title of Menu.';
COMMENT ON COLUMN public.menu.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.menu.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.menu.ordem_exibicao IS 'Exibition order of Menu.';
COMMENT ON COLUMN public.menu.nivel_menu IS 'Menu Level. Ex:

0 - Main
1 - Top
2 - Item
3 - Sub Item';
COMMENT ON COLUMN public.menu.menu_pai_id IS 'Id of Menu Parent.(Auto FK)';
COMMENT ON COLUMN public.menu.restrito IS 'Is restricted ?';

CREATE SEQUENCE public.menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.menu_id_seq OWNER TO postgres;

ALTER SEQUENCE public.menu_id_seq OWNED BY public.menu.id;

COMMENT ON SEQUENCE public.menu_id_seq IS 'Sequence for menu table.';

CREATE TABLE public.modulo (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    descricao text NOT NULL,
    base_path character varying(255) NOT NULL
);

ALTER TABLE public.modulo OWNER TO postgres;

COMMENT ON TABLE public.modulo IS 'Avaliables Modules Table.';
COMMENT ON COLUMN public.modulo.id IS 'Id of Module.';
COMMENT ON COLUMN public.modulo.titulo IS ' Title of Module.';
COMMENT ON COLUMN public.modulo.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.modulo.descricao IS 'Description of Module.';
COMMENT ON COLUMN public.modulo.base_path IS 'Base path of module. Ex:

/gallery
/news
/services';

CREATE SEQUENCE public.modulo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.modulo_id_seq OWNER TO postgres;

ALTER SEQUENCE public.modulo_id_seq OWNED BY public.modulo.id;

COMMENT ON SEQUENCE public.modulo_id_seq IS 'Sequence for modulo table.';

CREATE TABLE public.parametro (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    nome character varying(255) NOT NULL,
    valor character varying(255) NOT NULL
);

ALTER TABLE public.parametro OWNER TO postgres;

COMMENT ON TABLE public.parametro IS 'Parameters of System Table.';
COMMENT ON COLUMN public.parametro.id IS ' Id of Parameter.';
COMMENT ON COLUMN public.parametro.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.parametro.nome IS 'Name of Parameter.';
COMMENT ON COLUMN public.parametro.valor IS 'Value of Parameter.';

CREATE SEQUENCE public.parametro_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.parametro_id_seq OWNER TO postgres;

ALTER SEQUENCE public.parametro_id_seq OWNED BY public.parametro.id;

COMMENT ON SEQUENCE public.parametro_id_seq IS 'Sequence for parametro table.';

CREATE TABLE public.produto (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    icone character varying(255) NOT NULL,
    detalhamento text NOT NULL
);

ALTER TABLE public.produto OWNER TO postgres;

COMMENT ON TABLE public.produto IS 'Products of System Table.';
COMMENT ON COLUMN public.produto.id IS 'Id of Product.';
COMMENT ON COLUMN public.produto.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.produto.titulo IS 'Title of Product.';
COMMENT ON COLUMN public.produto.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.produto.icone IS ' Address of URL/Link of Icon that represents the  Product. (Internal Link)';
COMMENT ON COLUMN public.produto.detalhamento IS 'Details of Product.';

CREATE TABLE public.produto_categoria (
    empresa_id integer NOT NULL,
    produto_id integer NOT NULL,
    categoria_produto_id integer NOT NULL
);

ALTER TABLE public.produto_categoria OWNER TO postgres;

COMMENT ON TABLE public.produto_categoria IS 'Category x Products of System Table.';

COMMENT ON COLUMN public.produto_categoria.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.produto_categoria.produto_id IS 'Id of Product Table (FK).';
COMMENT ON COLUMN public.produto_categoria.categoria_produto_id IS 'Id of Category of Product Table (FK).';

CREATE SEQUENCE public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.produto_id_seq OWNER TO postgres;
ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;

COMMENT ON SEQUENCE public.produto_id_seq IS 'Sequence for produto table.';

CREATE TABLE public.profissional (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    icone character varying(255) NOT NULL,
    foto character varying(255) NOT NULL,
    mini_curriculo text NOT NULL
);

ALTER TABLE public.profissional OWNER TO postgres;

COMMENT ON TABLE public.profissional IS 'Professionals of System Table.';
COMMENT ON COLUMN public.profissional.id IS ' Id of Professional.';
COMMENT ON COLUMN public.profissional.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.profissional.titulo IS 'Title of Professional.';
COMMENT ON COLUMN public.profissional.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.profissional.icone IS 'Address of URL/Link of Icon that represents the  Professional. (Internal Link)';
COMMENT ON COLUMN public.profissional.foto IS 'Address of URL/Link of Photo Professional. (External Link)';
COMMENT ON COLUMN public.profissional.mini_curriculo IS 'Resume of Professional.';

CREATE SEQUENCE public.profissional_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.profissional_id_seq OWNER TO postgres;

ALTER SEQUENCE public.profissional_id_seq OWNED BY public.profissional.id;

COMMENT ON SEQUENCE public.profissional_id_seq IS 'Sequence for profissional table.';

CREATE TABLE public.profissional_servico (
    empresa_id integer NOT NULL,
    profissional_id integer NOT NULL,
    servico_id integer NOT NULL
);

ALTER TABLE public.profissional_servico OWNER TO postgres;

COMMENT ON TABLE public.profissional_servico IS 'Professionals x Service of System Table.';
COMMENT ON COLUMN public.profissional_servico.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.profissional_servico.profissional_id IS 'Id of Professional Table (FK).';
COMMENT ON COLUMN public.profissional_servico.servico_id IS 'Id of Service Table (FK).';

CREATE TABLE public.publicacao (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    empresa_id integer NOT NULL,
    tipo_id integer NOT NULL,
    data_criacao timestamp with time zone NOT NULL,
    data_publicacao timestamp with time zone,
    hora_publicacao timestamp with time zone,
    descricao text NOT NULL,
    img_miniatura character varying(255) NOT NULL,
    intro text NOT NULL,
    conteudo text NOT NULL,
    palavras_chaves character varying(255) NOT NULL,
    destaque boolean NOT NULL,
    permite_comentario boolean NOT NULL,
    rascunho boolean NOT NULL
);

ALTER TABLE public.publicacao OWNER TO postgres;

COMMENT ON TABLE public.publicacao IS 'Publications of System Table.';
COMMENT ON COLUMN public.publicacao.id IS 'Id of Publication.';
COMMENT ON COLUMN public.publicacao.titulo IS 'Title of Publication.';
COMMENT ON COLUMN public.publicacao.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.publicacao.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.publicacao.tipo_id IS 'Id of Type Publication Table (FK).';
COMMENT ON COLUMN public.publicacao.data_criacao IS 'Date/Time of publication creation.';
COMMENT ON COLUMN public.publicacao.data_publicacao IS 'Published date.';
COMMENT ON COLUMN public.publicacao.hora_publicacao IS 'Publish time.';
COMMENT ON COLUMN public.publicacao.descricao IS 'Description of Publication.';
COMMENT ON COLUMN public.publicacao.img_miniatura IS 'Address of URL/Link of Icon that represents the  Publication. (Internal Link)';
COMMENT ON COLUMN public.publicacao.intro IS 'Intro of Content.';
COMMENT ON COLUMN public.publicacao.conteudo IS 'Full content of publication.';
COMMENT ON COLUMN public.publicacao.palavras_chaves IS 'Keywords of publication.';
COMMENT ON COLUMN public.publicacao.destaque IS 'Is featured ?';
COMMENT ON COLUMN public.publicacao.permite_comentario IS 'Can comments ?';
COMMENT ON COLUMN public.publicacao.rascunho IS 'Is draft ?';

CREATE SEQUENCE public.publicacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.publicacao_id_seq OWNER TO postgres;

ALTER SEQUENCE public.publicacao_id_seq OWNED BY public.publicacao.id;

COMMENT ON SEQUENCE public.publicacao_id_seq IS 'Sequence for publicacao table.';

CREATE TABLE public.servico (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    icone character varying(255) NOT NULL,
    detalhamento text NOT NULL
);

ALTER TABLE public.servico OWNER TO postgres;

COMMENT ON TABLE public.servico IS 'Services of System Table.';
COMMENT ON COLUMN public.servico.id IS 'Id of Service.';
COMMENT ON COLUMN public.servico.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.servico.titulo IS 'Title of Service.';
COMMENT ON COLUMN public.servico.slug IS 'Slug (auto-generated) field.';
COMMENT ON COLUMN public.servico.icone IS 'Address of URL/Link of Icon that represents the  Service. (Internal Link)';
COMMENT ON COLUMN public.servico.detalhamento IS 'Details of Service.';

CREATE SEQUENCE public.servico_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.servico_id_seq OWNER TO postgres;

ALTER SEQUENCE public.servico_id_seq OWNED BY public.servico.id;

COMMENT ON SEQUENCE public.servico_id_seq IS 'Sequence for servico table.';

CREATE TABLE public.tipo_publicacao (
    id integer NOT NULL,
    empresa_id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    slug character varying(255) NOT NULL
);

ALTER TABLE public.tipo_publicacao OWNER TO postgres;

COMMENT ON TABLE public.tipo_publicacao IS 'Type of Publications Table.';
COMMENT ON COLUMN public.tipo_publicacao.id IS 'Id of Type of Publication.';
COMMENT ON COLUMN public.tipo_publicacao.empresa_id IS 'Id of Empresa Table (FK).';
COMMENT ON COLUMN public.tipo_publicacao.titulo IS 'Title of Type of Publication.';
COMMENT ON COLUMN public.tipo_publicacao.slug IS ' Slug (auto-generated) field.';

CREATE SEQUENCE public.tipo_publicacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.tipo_publicacao_id_seq OWNER TO postgres;

ALTER SEQUENCE public.tipo_publicacao_id_seq OWNED BY public.tipo_publicacao.id;

COMMENT ON SEQUENCE public.tipo_publicacao_id_seq IS 'Sequence for tipo_publicacao table.';

SELECT pg_catalog.setval('public.auth_group_id_seq', 1, false);
SELECT pg_catalog.setval('public.auth_group_permissions_id_seq', 1, false);
SELECT pg_catalog.setval('public.auth_permission_id_seq', 1, false);
SELECT pg_catalog.setval('public.auth_user_groups_id_seq', 1, false);
SELECT pg_catalog.setval('public.auth_user_id_seq', 1, false);
SELECT pg_catalog.setval('public.auth_user_user_permissions_id_seq', 1, false);
SELECT pg_catalog.setval('public.banner_id_seq', 1, false);
SELECT pg_catalog.setval('public.categoria_produto_id_seq', 1, false);
SELECT pg_catalog.setval('public.empresa_id_seq', 1, false);
SELECT pg_catalog.setval('public.endereco_id_seq', 1, false);
SELECT pg_catalog.setval('public.especialidade_id_seq', 1, false);
SELECT pg_catalog.setval('public.galeria_id_seq', 1, false);
SELECT pg_catalog.setval('public.galeria_midia_id_seq', 1, false);
SELECT pg_catalog.setval('public.loggy_id_seq', 1, false);
SELECT pg_catalog.setval('public.mensagem_id_seq', 1, false);
SELECT pg_catalog.setval('public.menu_id_seq', 1, false);
SELECT pg_catalog.setval('public.modulo_id_seq', 1, false);
SELECT pg_catalog.setval('public.parametro_id_seq', 1, false);
SELECT pg_catalog.setval('public.produto_id_seq', 1, false);
SELECT pg_catalog.setval('public.profissional_id_seq', 1, false);
SELECT pg_catalog.setval('public.publicacao_id_seq', 1, false);
SELECT pg_catalog.setval('public.servico_id_seq', 1, false);
SELECT pg_catalog.setval('public.tipo_publicacao_id_seq', 1, false);

ALTER TABLE ONLY public.auth_group ADD CONSTRAINT auth_group_name_key UNIQUE (name);
ALTER TABLE ONLY public.auth_group_permissions ADD CONSTRAINT auth_group_permissions_group_id_permission_id_key UNIQUE (group_id, permission_id);
ALTER TABLE ONLY public.auth_group_permissions ADD CONSTRAINT auth_group_permissions_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.auth_group ADD CONSTRAINT auth_group_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.auth_permission ADD CONSTRAINT auth_permission_content_type_id_codename_key UNIQUE (content_type_id, codename);
ALTER TABLE ONLY public.auth_permission ADD CONSTRAINT auth_permission_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.auth_user_groups ADD CONSTRAINT auth_user_groups_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.auth_user_groups ADD CONSTRAINT auth_user_groups_user_id_group_id_key UNIQUE (user_id, group_id);
ALTER TABLE ONLY public.auth_user ADD CONSTRAINT auth_user_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.auth_user_user_permissions ADD CONSTRAINT auth_user_user_permissions_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.auth_user_user_permissions ADD CONSTRAINT auth_user_user_permissions_user_id_permission_id_key UNIQUE (user_id, permission_id);
ALTER TABLE ONLY public.auth_user ADD CONSTRAINT auth_user_username_key UNIQUE (username);
ALTER TABLE ONLY public.banner ADD CONSTRAINT banner_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.banner ADD CONSTRAINT banner_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.banner ADD CONSTRAINT banner_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.categoria_produto ADD CONSTRAINT categoria_produto_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.categoria_produto ADD CONSTRAINT categoria_produto_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.categoria_produto ADD CONSTRAINT categoria_produto_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.empresa_modulo ADD CONSTRAINT empresa_modulo_empresa_id_modulo_id_key UNIQUE (empresa_id, modulo_id);
ALTER TABLE ONLY public.empresa_modulo ADD CONSTRAINT empresa_modulo_pkey PRIMARY KEY (empresa_id, modulo_id);
ALTER TABLE ONLY public.empresa ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.empresa ADD CONSTRAINT empresa_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.empresa ADD CONSTRAINT empresa_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.endereco ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.especialidade ADD CONSTRAINT especialidade_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.especialidade ADD CONSTRAINT especialidade_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.especialidade ADD CONSTRAINT especialidade_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.galeria_midia ADD CONSTRAINT galeria_midia_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.galeria ADD CONSTRAINT galeria_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.galeria ADD CONSTRAINT galeria_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.galeria ADD CONSTRAINT galeria_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.loggy ADD CONSTRAINT loggy_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.mensagem ADD CONSTRAINT mensagem_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.menu ADD CONSTRAINT menu_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.menu ADD CONSTRAINT menu_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.menu ADD CONSTRAINT menu_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.modulo ADD CONSTRAINT modulo_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.modulo ADD CONSTRAINT modulo_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.modulo ADD CONSTRAINT modulo_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.parametro ADD CONSTRAINT parametro_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.produto_categoria ADD CONSTRAINT produto_categoria_pkey PRIMARY KEY (produto_id, categoria_produto_id);
ALTER TABLE ONLY public.produto_categoria ADD CONSTRAINT produto_categoria_produto_id_categoria_produto_id_key UNIQUE (produto_id, categoria_produto_id);
ALTER TABLE ONLY public.produto ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.produto ADD CONSTRAINT produto_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.produto ADD CONSTRAINT produto_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.profissional ADD CONSTRAINT profissional_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.profissional_servico ADD CONSTRAINT profissional_servico_pkey PRIMARY KEY (profissional_id, servico_id);
ALTER TABLE ONLY public.profissional_servico ADD CONSTRAINT profissional_servico_profissional_id_servico_id_key UNIQUE (profissional_id, servico_id);
ALTER TABLE ONLY public.profissional ADD CONSTRAINT profissional_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.profissional ADD CONSTRAINT profissional_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.publicacao ADD CONSTRAINT publicacao_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.publicacao ADD CONSTRAINT publicacao_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.publicacao ADD CONSTRAINT publicacao_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.servico ADD CONSTRAINT servico_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.servico ADD CONSTRAINT servico_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.servico ADD CONSTRAINT servico_titulo_key UNIQUE (titulo);
ALTER TABLE ONLY public.tipo_publicacao ADD CONSTRAINT tipo_publicacao_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.tipo_publicacao ADD CONSTRAINT tipo_publicacao_slug_key UNIQUE (slug);
ALTER TABLE ONLY public.tipo_publicacao ADD CONSTRAINT tipo_publicacao_titulo_key UNIQUE (titulo);

CREATE INDEX auth_group_name_253ae2a6331666e8_like ON public.auth_group USING btree (name varchar_pattern_ops);
CREATE INDEX auth_group_permissions_0e939a4f ON public.auth_group_permissions USING btree (group_id);
CREATE INDEX auth_group_permissions_8373b171 ON public.auth_group_permissions USING btree (permission_id);
CREATE INDEX auth_permission_417f1b1c ON public.auth_permission USING btree (content_type_id);
CREATE INDEX auth_user_groups_0e939a4f ON public.auth_user_groups USING btree (group_id);
CREATE INDEX auth_user_groups_e8701ad4 ON public.auth_user_groups USING btree (user_id);
CREATE INDEX auth_user_user_permissions_8373b171 ON public.auth_user_user_permissions USING btree (permission_id);
CREATE INDEX auth_user_user_permissions_e8701ad4 ON public.auth_user_user_permissions USING btree (user_id);
CREATE INDEX auth_user_username_51b3b110094b8aae_like ON public.auth_user USING btree (username varchar_pattern_ops);
CREATE INDEX banner_slug_like ON public.banner USING btree (slug varchar_pattern_ops);
CREATE INDEX banner_titulo_like ON public.banner USING btree (titulo varchar_pattern_ops);
CREATE INDEX categoria_produto_slug_like ON public.categoria_produto USING btree (slug varchar_pattern_ops);
CREATE INDEX categoria_produto_titulo_like ON public.categoria_produto USING btree (titulo varchar_pattern_ops);
CREATE INDEX empresa_slug_like ON public.empresa USING btree (slug varchar_pattern_ops);
CREATE INDEX empresa_titulo_like ON public.empresa USING btree (titulo varchar_pattern_ops);
CREATE INDEX especialidade_slug_like ON public.especialidade USING btree (slug varchar_pattern_ops);
CREATE INDEX especialidade_titulo_like ON public.especialidade USING btree (titulo varchar_pattern_ops);
CREATE INDEX galeria_slug_like ON public.galeria USING btree (slug varchar_pattern_ops);
CREATE INDEX galeria_titulo_like ON public.galeria USING btree (titulo varchar_pattern_ops);
CREATE INDEX mensagem_assunto_like ON public.mensagem USING btree (assunto varchar_pattern_ops);
CREATE INDEX menu_slug_like ON public.menu USING btree (slug varchar_pattern_ops);
CREATE INDEX menu_titulo_like ON public.menu USING btree (titulo varchar_pattern_ops);
CREATE INDEX modulo_slug_like ON public.modulo USING btree (slug varchar_pattern_ops);
CREATE INDEX modulo_titulo_like ON public.modulo USING btree (titulo varchar_pattern_ops);
CREATE INDEX parametro_nome_like ON public.parametro USING btree (nome varchar_pattern_ops);
CREATE INDEX produto_slug_like ON public.produto USING btree (slug varchar_pattern_ops);
CREATE INDEX produto_titulo_like ON public.produto USING btree (titulo varchar_pattern_ops);
CREATE INDEX profissional_slug_like ON public.profissional USING btree (slug varchar_pattern_ops);
CREATE INDEX profissional_titulo_like ON public.profissional USING btree (titulo varchar_pattern_ops);
CREATE INDEX publicacao_slug_like ON public.publicacao USING btree (slug varchar_pattern_ops);
CREATE INDEX publicacao_titulo_like ON public.publicacao USING btree (titulo varchar_pattern_ops);
CREATE INDEX servico_slug_like ON public.servico USING btree (slug varchar_pattern_ops);
CREATE INDEX servico_titulo_like ON public.servico USING btree (titulo varchar_pattern_ops);
CREATE INDEX tipo_publicacao_slug_like ON public.tipo_publicacao USING btree (slug varchar_pattern_ops);
CREATE INDEX tipo_publicacao_titulo_like ON public.tipo_publicacao USING btree (titulo varchar_pattern_ops);

ALTER TABLE ONLY public.auth_group ADD CONSTRAINT auth_group_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_group_permissions ADD CONSTRAINT auth_group_permissio_group_id_689710a9a73b7457_fk_auth_group_id FOREIGN KEY (group_id) REFERENCES public.auth_group(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_group_permissions ADD CONSTRAINT auth_group_permission_id_1f49ccbbdc69d2fc_fk_auth_permission_id FOREIGN KEY (permission_id) REFERENCES public.auth_permission(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_group_permissions ADD CONSTRAINT auth_group_permissions_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_permission ADD CONSTRAINT auth_permission_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user_user_permissions ADD CONSTRAINT auth_user__permission_id_384b62483d7071f0_fk_auth_permission_id FOREIGN KEY (permission_id) REFERENCES public.auth_permission(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user ADD CONSTRAINT auth_user_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user_groups ADD CONSTRAINT auth_user_groups_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user_groups ADD CONSTRAINT auth_user_groups_group_id_33ac548dcf5f8e37_fk_auth_group_id FOREIGN KEY (group_id) REFERENCES public.auth_group(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user_groups ADD CONSTRAINT auth_user_groups_user_id_4b5ed4ffdb8fd9b0_fk_auth_user_id FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user_user_permissions ADD CONSTRAINT auth_user_user_permiss_user_id_7f0938558328534a_fk_auth_user_id FOREIGN KEY (user_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.auth_user_user_permissions ADD CONSTRAINT auth_user_user_permissions_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.banner ADD CONSTRAINT banner_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.categoria_produto ADD CONSTRAINT categoria_produto_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.empresa_modulo ADD CONSTRAINT empresa_modulo_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.empresa_modulo ADD CONSTRAINT empresa_modulo_fk_modulo_id FOREIGN KEY (modulo_id) REFERENCES public.modulo(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.endereco ADD CONSTRAINT endereco_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.especialidade ADD CONSTRAINT especialidade_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.galeria ADD CONSTRAINT galeria_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.galeria_midia ADD CONSTRAINT galeria_midia_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.galeria_midia ADD CONSTRAINT galeria_midia_fk_galeria_id FOREIGN KEY (galeria_id) REFERENCES public.galeria(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.loggy ADD CONSTRAINT loggy_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.loggy ADD CONSTRAINT loggy_fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES public.auth_user(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.mensagem ADD CONSTRAINT mensagem_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.menu ADD CONSTRAINT menu_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.menu ADD CONSTRAINT menu_fk_menu_pai_id FOREIGN KEY (menu_pai_id) REFERENCES public.menu(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.parametro ADD CONSTRAINT parametro_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.produto_categoria ADD CONSTRAINT produto_categoria_fk_categoria_produto_id FOREIGN KEY (categoria_produto_id) REFERENCES public.categoria_produto(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.produto_categoria ADD CONSTRAINT produto_categoria_fk_produto_id FOREIGN KEY (produto_id) REFERENCES public.produto(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.produto ADD CONSTRAINT produto_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.profissional ADD CONSTRAINT profissional_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.profissional_servico ADD CONSTRAINT profissional_servico_fk_profissional_id FOREIGN KEY (profissional_id) REFERENCES public.profissional(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.profissional_servico ADD CONSTRAINT profissional_servico_fk_servico_id FOREIGN KEY (servico_id) REFERENCES public.servico(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.publicacao ADD CONSTRAINT publicacao_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.publicacao ADD CONSTRAINT publicacao_fk_tipo_id FOREIGN KEY (tipo_id) REFERENCES public.tipo_publicacao(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.servico ADD CONSTRAINT servico_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ONLY public.tipo_publicacao ADD CONSTRAINT tipo_publicacao_fk_empresa_id FOREIGN KEY (empresa_id) REFERENCES public.empresa(id) DEFERRABLE INITIALLY DEFERRED;
