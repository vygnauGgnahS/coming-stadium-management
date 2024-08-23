/*
 Navicat Premium Dump SQL

 Source Server         : mydb-connect
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : stadium_management

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 18/08/2024 15:06:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员姓名',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员账号',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员电话',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '管理员', 'admin', '1234', '1234567890', '第一位，超级');
INSERT INTO `admin` VALUES (2, '龚霞', 'uhynsbbkml', 'Vm7b', '18623431744', '数门看支组际或位类民点拉法道。节十究人治外己前极自即素。必出转真能织求形受一现名重完西。至能同就造当而年片题接交些入有次。');
INSERT INTO `admin` VALUES (3, '袁芳', 'tcuobfjra', 'KQH', '18103142568', '率小道代马根接应领机新它就由。至志对同去至节该容京们世军图意所。省西化它清过行军节石则新表回。再素向非开合装除般根展电积此主。');
INSERT INTO `admin` VALUES (4, '汪刚', 'qvyfuwti', 'sz@8t', '13146628661', '五领然型心色律区此准革火细。直争利改重向族如众领争品放。再开身么结状准证使选验京边图但度。般般派员只识领传许交与数。收些交各革好张表资要根安律心。增原些真线却等马备变着使机风长。');
INSERT INTO `admin` VALUES (5, '唐娜', 'broh', '#OB3%R', '19810502532', '到压但十路织流所油委她体指转象其油。关信高记太局话圆取受立之么记动干。先于格五品外三场保片主管名。品更小参系率走民不比红式回利。最成平专多需置角听则识单数影。值术运济金级线斯近委思等线面厂龙群。利别非标包强出元出管却消说等今须没增。');
INSERT INTO `admin` VALUES (6, '史娜', 'dbhem', 'ND30', '18112893385', '以县每六石重里压数高习速思长代。置解石全明史马山处极况调么影区。根必人水情格其叫白本选照看身问。火行他花石类或复何况只斗天意电飞展清。');
INSERT INTO `admin` VALUES (7, '田静', 'aoxqgbu', 'xHh^', '18638178161', '情科制圆位光六该应门节例易并以造。问第变热形候且消期属别机表公三空斗局。现主人经表称性解种度体般联龙或多料。型队却切体近传矿用合段难同。老查院间本矿越使料进经极状人系进一。只它且正派声度教由总他名接。之次期支些干今克之先八物属。');
INSERT INTO `admin` VALUES (8, '孙芳', 'yiqwzemr', 'SFZ9', '19816836873', '南线总再个志极声委提地实。多史门即边除书为收机分斯整备约土民布。低别人决向理气次织半在增断声共见。');
INSERT INTO `admin` VALUES (9, '黎勇', 'nojeqyrkwd', 'Lw#1', '18162976583', '法矿山市为约可容识月代正群全月。己格划拉角厂但两千并年究进。和口该五存率存石教党量消车值。组任类反性就圆物面知有不支用划再切。平亲达细分联将经切际连支低五发。');
INSERT INTO `admin` VALUES (10, '汤涛', 'znknvcf', 'z5R0tdV', '18610810853', '保求后指已想局类法集无局象正全又十。动论自子记天增边究史律布即段。济广十叫还民消深往斗时专工布。矿自接办非天容且准教作之人严飞性。回深须今白县划看常志没制听存。常建布点金装业美民本力则方完示报。');
INSERT INTO `admin` VALUES (11, '尹涛', 'woxtonxbq', 'cyt@', '18135275553', '备快任建意西包入性究高织真安道。小革标六花按美影节到资马证。花意集为思一包同条美了划金准。分容持效经该增外平必出小花难中想他构。解有记更性拉究你求整产工转政。率共二提音农社厂解等日空话便周你己。是况水积于情龙权导专公单线。');
INSERT INTO `admin` VALUES (12, '傅超', 'dbgivybbi', 'f#kDo0', '18647604315', '她满有联手却他六都满件统备领。而品场原同断许切业光般族立要装出次。北族效根离物学动斗少用同米。万候取就结音此风分低目前外际。如度正红带众立量音八满而具理得。');
INSERT INTO `admin` VALUES (13, '顾刚', 'kkwgiwu', 'weftRwc', '18172772133', '长龙军回候结革几基展置叫内以色价斯。产劳最受路外米开应小路万政义起长议。反王按按难每此质温思场精约准。前选结量决改又济力干又这重王。空示线任群调音事情文特须路业准号积。');
INSERT INTO `admin` VALUES (14, '锺超', 'oredyke', '8E6bj0[', '19868176870', '类区之反速加走众原或已外而但选实真号。教路重说组同证五商对单亲接按价。率家干文府半引县力同名研。示往线土相报党变线重部千。');
INSERT INTO `admin` VALUES (15, '方强', 'hiqfe', 's*IB95', '18142595452', '名车见技类器府内约放每目说青油名。转装九史入革共年收第中由。下界深国七于元没观整局易质前。组因总打今改火合记产你什无品工况。');
INSERT INTO `admin` VALUES (16, '江明', 'svvhhavj', 'z46', '13596227440', '时将写活指件好极程教己历空造被但。始斗统又市联军时正不本长转江子族。圆下体四关与类写无思山位教算往眼。你示派极写明九十民管音离有科元。人热团打出亲状元教革话角小分火六。受事劳六我干层活治龙改很响感单生式。');

-- ----------------------------
-- Table structure for advance_order
-- ----------------------------
DROP TABLE IF EXISTS `advance_order`;
CREATE TABLE `advance_order`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '预约订单',
  `user_id` int NOT NULL COMMENT '预约用户id',
  `co_id` int NULL DEFAULT NULL COMMENT '陪练教练id，可选项，可为空',
  `sp_id` int NOT NULL COMMENT '运动项目id',
  `spa_id` int NOT NULL COMMENT '运动场地id',
  `sub_time` datetime NOT NULL COMMENT '预约订单提交时间',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态，0为预约状态，1为完成状态，2为取消状态',
  `start_time` datetime NOT NULL COMMENT '预约开始时间',
  `end_time` datetime NOT NULL,
  `payment` decimal(10, 2) UNSIGNED NOT NULL COMMENT '支付费用',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '订单备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of advance_order
-- ----------------------------
INSERT INTO `advance_order` VALUES (1, 1, 2, 1, 2, '2024-08-13 16:23:26', '1', '2024-08-14 16:00:00', '2024-08-14 17:00:00', 120.00, '无');
INSERT INTO `advance_order` VALUES (2, 9, 3, 1, 2, '2024-08-15 20:15:55', '1', '2024-08-14 20:00:00', '2024-08-14 22:00:00', 440.00, '线列同是龙具政必老资明候是水军写完。段没高律都路石在响最规往状度。调几除此响空龙不厂头给么每白效深。水将但任式间比同特南得整今。十天划么想速想有一水做适热直常管。');
INSERT INTO `advance_order` VALUES (3, 8, 4, 1, 3, '2024-08-15 22:07:28', '1', '2024-08-15 20:00:00', '2024-08-15 23:00:00', 510.00, '线列同是龙具政必老资明候是水军写完。段没高律都路石在响最规往状度。调几除此响空龙不厂头给么每白效深。水将但任式间比同特南得整今。十天划么想速想有一水做适热直常管。');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教练id',
  `co_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教练姓名',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教练照片',
  `sp_id` int NOT NULL COMMENT '教练所指导的运动id',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教练性别',
  `birthday` date NOT NULL COMMENT '教练出生日期',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教练手机号',
  `price` decimal(10, 2) NOT NULL COMMENT '陪练价格',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES (1, '好教练', 'http://localhost:8080/avatar/coaches/11613769-4623-4a0e-b841-a64bb18ce540.jpg', 1, '男', '1985-02-12', '123342313', 200.00, '好教练');
INSERT INTO `coach` VALUES (2, '也好教练', 'http://localhost:8080/avatar/coaches/7a221d7e-6023-4370-bdbd-aac75c5a1353.jpg', 1, '女', '1990-08-10', '124534523', 100.00, '也好');
INSERT INTO `coach` VALUES (3, '阎强', 'http://dummyimage.com/100x100', 1, '女', '2016-12-02', '13382470127', 200.00, '全立中少此规分头身极南史空快原化流。温被酸政元海手结口进学红整清。志劳治济有议近现支太思道口律没素制。习酸取石影准几以况群深建门流利到开过。现千时划治农什四说色列式面。好十或年事如场路律力重消安观好收联西。');
INSERT INTO `coach` VALUES (4, '孟娟', 'http://dummyimage.com/100x100', 1, '女', '2010-04-20', '18187451268', 150.00, '是者口公精组光件集因何写外口步。受量效王比说必非得林同段条层。基列较放认许是阶万府备经情千当即其。很即级设科示装克件南反据气。温自划切热片书米低说运求律音段。');
INSERT INTO `coach` VALUES (5, '常军', 'http://dummyimage.com/100x100', 1, '女', '2011-12-09', '13384412692', 322.00, '政老他水合应近值领况基便儿易象越。世了存他联规太许种历因很江给什门包。果得十值多比书空际认次图边器清效般得。已导形所率使任更改员三称设低理新。工干什看适眼取习众打质最料家成。家满里什象次化气五为严是率。带素每本派决心社事须龙力西无两也。');
INSERT INTO `coach` VALUES (6, '丁艳', 'http://dummyimage.com/100x100', 1, '男', '1997-11-14', '19800567092', 250.00, '书同切革从使议段段管达西图。却划没面千清成温于体把革收前。多它完统回资规电米边感导相要根。山适质表学离节教农东八东两流。三克素对织且本个共知切织具取子年。东何年什往克建区群特七今维该。');
INSERT INTO `coach` VALUES (7, '名字', 'http://dummyimage.com/100x100', 2, '男', '2024-08-15', '123454534', 2341.00, '阿斯顿发各位');

-- ----------------------------
-- Table structure for sports
-- ----------------------------
DROP TABLE IF EXISTS `sports`;
CREATE TABLE `sports`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '运动项目id',
  `sp_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运动名称',
  `price` decimal(10, 2) NOT NULL COMMENT '运动项目场地费用，元/小时',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sports
-- ----------------------------
INSERT INTO `sports` VALUES (1, '乒乓球', 20.00, '打乒乓球好啊');
INSERT INTO `sports` VALUES (2, '羽毛球', 25.00, '打羽毛球好啊');
INSERT INTO `sports` VALUES (3, '篮球', 50.00, NULL);
INSERT INTO `sports` VALUES (4, '网球', 50.00, NULL);
INSERT INTO `sports` VALUES (5, '排球', 60.00, NULL);
INSERT INTO `sports` VALUES (6, '游泳', 30.00, NULL);

-- ----------------------------
-- Table structure for sports_area
-- ----------------------------
DROP TABLE IF EXISTS `sports_area`;
CREATE TABLE `sports_area`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '体育运动场地id',
  `area_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运动场地名',
  `sp_id` int NOT NULL COMMENT '所属运动id',
  `status` char(1) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '0' COMMENT '当前场地状态，0表示可用，1表示不可用',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sports_area
-- ----------------------------
INSERT INTO `sports_area` VALUES (1, '1号乒乓球台', 1, '0', NULL);
INSERT INTO `sports_area` VALUES (2, '2号乒乓球台', 1, '0', NULL);
INSERT INTO `sports_area` VALUES (3, '3号乒乓球台', 1, '0', '快来玩啊');
INSERT INTO `sports_area` VALUES (4, '4号乒乓球台', 1, '1', '场地维修中');
INSERT INTO `sports_area` VALUES (5, '5号乒乓球台', 1, '0', '');
INSERT INTO `sports_area` VALUES (6, '6号乒乓球台', 1, '0', '');
INSERT INTO `sports_area` VALUES (7, '7号乒乓球台', 1, '1', '场地维修中');
INSERT INTO `sports_area` VALUES (8, '1号羽毛球场', 2, '1', '场地维修中');
INSERT INTO `sports_area` VALUES (9, '2号羽毛球场', 2, '0', '打羽毛球吧');
INSERT INTO `sports_area` VALUES (10, '3号羽毛球场', 2, '0', '打打打');
INSERT INTO `sports_area` VALUES (11, '1号篮球场', 3, '1', '正在修建');
INSERT INTO `sports_area` VALUES (12, '8号乒乓球台', 1, '0', '打打打打打');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
  `nickname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '默认用户' COMMENT '用户昵称',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号用户名',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号密码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `qq` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '蕾缪乐', '天使小乐', 'lml123', '123lml', '女', '2003-12-24', '233233233', 'http://localhost:8080/avatar/users/417ca328-121d-44f5-8bff-7f47285897de.jpg', '233233233', '123456', '无');
INSERT INTO `user` VALUES (2, '白娜', '算', 'jfnhystb', 'enim', '女', '1981-12-30', '19835044150', 'http://localhost:8080/avatar/users/baba7626-9007-4927-a33e-619223b9c435.jpg', 'anim', '127877123', '市组研反速深信米用都状但方。各声局保手外始层油水际便称下。条价较务地许能几公育列之。物指物油地非交风却却日研拉消并义角。');
INSERT INTO `user` VALUES (3, '韩超', '率', 'cdsyg', 'veniam', '男', '2005-11-29', '18184392515', 'http://dummyimage.com/100x100', 'sit dolor officia quis ullamco', 'tempor non anim officia', '最周以带百向四知己由话美商改级斯列。发业般间列会毛越再院六专联采很连设增。矿民参通八子下通给见发算王物角有专。品群提受公间低世易非而己线只须油。行照最斯中研效入管拉其好千什北时。');
INSERT INTO `user` VALUES (4, '贾强', '结', 'oanq', 'commodo aute eiusmod', '女', '2021-07-21', '18633358391', 'http://dummyimage.com/100x100', 'culpa est in aute', 'sint', '劳电利市采区习十可料确层年。毛议治物安无空合决万科越花技酸导识以。持以青信革也比规共龙代新地装运。利规别相究更常党战目达万油三为长价。们件此各得权先共类质完相带期教较己。大等史今育万已音或平离党把持。年便进局从重提任金第按给路除。');
INSERT INTO `user` VALUES (5, '苏平', '常', 'yterycmhh', 'occaecat in dolor', '男', '2007-09-26', '19856478786', 'http://dummyimage.com/100x100', 'in sint nos', 'id ut et quis', '矿题研程列光又六内圆拉并区交规北安口。动是务做来业酸取红共派米研龙采想风。里热太车说标精海水四示再被马。表场指花律六约日周金再面积老。给它场型我消集图实据越比只。在收况还他时般于亲代又千但工响。');
INSERT INTO `user` VALUES (6, '汤刚', '办', 'hhgwtwv', 'ad eu ut laboru', '男', '1979-02-10', '19877881885', 'http://dummyimage.com/100x100', 'ea cup', 'in anim', '改得再声片克程看亲议等走。原整际王给律红命效向张此近变。高打构平象亲习反江天子照越查育且老集。他多该连何准家万花可属参月最。');
INSERT INTO `user` VALUES (7, '苏超', '们', 'hdcgxif', 'est ', '女', '1992-10-17', '18154761452', 'http://dummyimage.com/100x100', 'reprehenderit anim ad Ut f', 'Duis laborum esse sunt dolore', '类消变意养习位力装比动会观养。天拉身传实果传各说权性后至才与确我委。己来业小感意近且于查示精记。感与车规不学它义条新书段置还。规越照根八强细济段战人取际立王技。');
INSERT INTO `user` VALUES (8, '许静', '进', 'lnllwd', 'sint pariatur', '男', '1977-02-21', '18606651673', 'http://dummyimage.com/100x100', 'irure culpa Duis commo', 'minim eu cupidatat deserunt aute', '动国速设整事此直原西那手太少品。质便清则级关量何飞毛们战分族转关务铁。完调与七南关家调比济发器转头新争无。生装还情光东平议受他意表其。');
INSERT INTO `user` VALUES (9, '康强', '太', 'vcxby', 'ea dolor incididunt', '男', '2002-03-04', '19822786181', 'http://dummyimage.com/100x100', 'pariatur in enim', 'et', '新真段人了器白很写支带半又并。小解战说什来听里何派质进太府话了声工。场导程运事联联从们重又数查习里不革地。打电学及局划世住基社调产政。');
INSERT INTO `user` VALUES (10, '段勇', '音', 'ubpkezxpm', 'amet aliquip', '男', '1985-12-30', '18171115756', 'http://dummyimage.com/100x100', 'in amet incididunt', 'pariatur est amet deserunt', '家市深与难满型低业须办志再动改米细。特极与决通关保决立提基手会受办与。商精文感越情加义有须又经军属完。开写达品面看快老资省压展地则常式电史。体准生二车比复只关身石民美许克。流议广做历只场花道效业积构内清。间精叫口将与指四条争适派以当识重技片。');
INSERT INTO `user` VALUES (11, '崔秀英', '离', 'edvccfig', 'ex sunt amet', '女', '2003-06-27', '13296122757', 'http://dummyimage.com/100x100', 'pariatur ', 'do enim', '天济务反做四元声入就命多根直半写口。流是酸声往研边成九风正五来。四么始再什头精利海己名已主全住。统两证方史在作强积单化证流严。此最按认而文证收积方办数安都。实总战器你二并张参造研美能龙委。');
INSERT INTO `user` VALUES (12, '宋秀英', '厂', 'potvvvh', 'in offici', '男', '1970-12-15', '19809433956', 'http://dummyimage.com/100x100', 'anim dolore sunt in', 'incididunt irure veniam minim', '四结照连素处光新年对往斯感许。制率式深要按研去为月象究。院保叫算作运效要比三结向构是及没。决断标万七南质时安线论理维真。而完格即传克酸它平需采然引结边万阶。八提特立人正日接走际研却各军。');
INSERT INTO `user` VALUES (13, '谭洋', '历', 'eeir', 'Excepteur pariatur id', '男', '2012-11-24', '19824588135', 'http://dummyimage.com/100x100', 'deserunt', 'aliqui', '价己物容了的斗员组素正处阶往月路题列。价严解关五见志北第事据近己持千王共。目设种或解交两复达然走江据快无发斯持。求照又之价交被流文府县拉较放联世。');
INSERT INTO `user` VALUES (14, '冯秀英', '克', 'tisqgy', 'nulla voluptate ad cu', '男', '1986-05-06', '18129969582', 'http://dummyimage.com/100x100', 'do Duis ', 'eu fugiat aliqua', '法命火活民力后据线北转当论那。调写里难引可当从越发新算于统报改。号原林除生话元月府资色满形治并标。育值制议叫手真那加列到光即半。复色下的取她造文八后效确国增斗式心。当九构号办经东集后北南半观采快之。');
INSERT INTO `user` VALUES (15, '方娜', '属', 'ybi', 'eius', '男', '1996-05-27', '18684636471', 'http://dummyimage.com/100x100', 'ut sunt Ut', 'laborum', '起支准高革家装变土才群压第火。状属层严单办西手论西了并规委机济队。儿面可段消从商业引动非边而团大六。');
INSERT INTO `user` VALUES (16, '范娜', '严', 'vdtxoek', 'nost', '女', '1973-02-23', '18603861191', 'http://dummyimage.com/100x100', 'irure', 'et laboris Duis', '节习件身发前叫林实切青论再海位什。开王位中目学就划能太出变可金。义史单间近委济半两着众此除干适克。没相极此计得员间传论部区反九究容科。低维技写写具属治率收例会如目将可。色他都军程料快接美关行好设阶造角平。安际三于利小统设话理信记无确五眼节铁。');
INSERT INTO `user` VALUES (17, '万霞', '查', 'gbjvwzxnd', 'GTv&@a', '男', '2019-02-14', '18127299630', 'http://dummyimage.com/120x600', 'skm6W', '4758433', '红非真听价热物响度集山流各力书持。织候术清群象理阶况件张派部新化江。教展天受传矿很它受美题状心可式存次。点是经能达别天太需电或教圆发。而所铁方属集她的报增头起心温于积。便原色说斯具在需方据题先改油想识全。');
INSERT INTO `user` VALUES (18, '沃尔', '好听的名字', '23qsd', '12dgr', '男', '2024-08-05', '12411241', 'http://localhost:8080/avatar/users/c2a989d5-2e22-4265-a60b-fc3980ebc1ea.jpg', '12414', '1241514', '安慰人嘎尔尕尔哈尔和');

SET FOREIGN_KEY_CHECKS = 1;
