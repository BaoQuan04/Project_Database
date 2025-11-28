/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.steam.ui;

import com.steam.model.*;
import com.steam.model.User;
import com.steam.repository.*;
import com.steam.repository.impl.*;
import com.steam.service.*;
import com.steam.service.UserService;
import com.steam.service.impl.*;
import com.steam.util.ImageCache;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.ComboPopup;
import java.util.*;
import java.util.concurrent.ExecutionException;


/**
 *
 * @author Toyo
 */


public class MainMenu extends javax.swing.JFrame {
    private java.awt.CardLayout c1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainMenu.class.getName());
    private JButton selectedButton = null;
    private JButton selectedButtonGameInStore = null;
    private int selectedButtonGameInStoreIndex;
    private JPanel selectedPanelGameInLibrary;
    private JButton selectedButInJTool;
    private JPanel hoveredPanelGameInStore;
    //test
    //private java.util.List<GameInfo> gameUserPurchasedTest = new ArrayList<>();
    private java.util.List<Game> gameFoundViaName = new ArrayList<>();
    private DefaultComboBoxModel<GeneralInfo> model;
    private volatile boolean updatingModel = false;
    private boolean isInPopup = true;
    private int numberGamesUserPurchased = 0;
    JTextField editor;
    
    
    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final UserService userService = new UserServiceImpl(userRepository);
    private static final GameRepository gameRepository = new GameRepositoryImpl();
    private static final DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
    //private static final GameService gameService = new GameService
    private static final ReviewRepository reviewRepository = new ReviewRepositoryImpl();
    private static final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private static final ContainRepository containRepository = new ContainRepositoryImpl();
    private static final GameService gameService = new GameServiceImpl();
    private static final TransactionRepository transactionRepository = new TransactionRepositoryImpl();
    private static final TransactionService transactionService = new TransactionServiceImpl(
            userRepository,
            gameRepository,
            transactionRepository,
            containRepository
    );
    private User userInfo;
    private DLLForChangeContent dll;
    private Node currentNode;
    //private java.util.List<Game> dataToLoadForGameInStore = new ArrayList<>();
    private java.util.List<String> ratingFirGameInStore = new ArrayList<>();
    private java.util.List<Game> gameQuerry8;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Map<String, ImageIcon> imageCache = new HashMap<>();
    //private javax.swing.JComboBox<GameItem> comboBox;
    // /test
    //private final java.util.List<JLabel> thumbList = new ArrayList<>();
    /**
     * Creates new form mainMenu
     */
    public MainMenu(User inputUserInfo) {
        super("Steam");
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        gameQuerry8 = gameService.getAllGames();
        ImageCache.preloadAllImages(gameQuerry8);
        initComponents();
        selectedButInJTool = btnStore;
        selectedButInJTool.setForeground(Color.decode("#00A3FF"));
        butYes.setActionCommand("Yes");
        butNo.setActionCommand("No");
        dll = new DLLForChangeContent();
        dll.addLast(new storeDLL());
        currentNode = dll.getTail();
        userInfo = inputUserInfo;
        jScrollPane5.setViewportView(jPanel67);
        //jScrollPane6.setViewportView(panelListGameDev);
        //scrollPanelDevs.setViewportView(p);
        //scrollPanelDevs.setViewportView(panelListGameDev);
        //jScrollPane2.setViewportView(jPanel);
        //jScrollPane2.getViewport().setView(jPanel36);
        //jScrollPane5.setViewportView(main);
        // Ví dụ bạn có jLabel1 hiển thị ảnh
        setLocationRelativeTo(null);
        this.setResizable(false);
        System.out.println(userInfo.getUserName());
        System.out.println(userInfo.getUserId());
        System.out.println(userInfo.getEmail());
        lblBalance.setText("Balance: " + Double.toString(userInfo.getWalletBalance())+" VND");
        c1 = (java.awt.CardLayout) mainContainer.getLayout();
        initTestSearch();
        //addPlaceholder(txtSearch, "Search the store");
        initStore();
        initHoverListener();
        initGameInLibrary(userInfo);
        scrollPanelStore.getVerticalScrollBar().setUnitIncrement(30);
        scrollPanelGame.getVerticalScrollBar().setUnitIncrement(30);
        scrollPaneLibrary.getVerticalScrollBar().setUnitIncrement(30);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(30);
        scrollPaneGamesGenre.getVerticalScrollBar().setUnitIncrement(30);
        scrollPanelReviewsGame.getVerticalScrollBar().setUnitIncrement(30);
        scrollPanelDevs.getVerticalScrollBar().setUnitIncrement(30);
        jPanel34.setVisible(false);
        jToolBar1.setFloatable(false);
        lblGameTag.setText(lblTagGameInStore1.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        btnPreviousContainer = new javax.swing.JButton();
        btnNextContainer = new javax.swing.JButton();
        btnStore = new javax.swing.JButton();
        btnLibrary = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        lblBalance = new javax.swing.JLabel();
        mainContainer = new javax.swing.JPanel();
        scrollPanelStore = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        btnImg1 = new javax.swing.JButton();
        btnImg2 = new javax.swing.JButton();
        btnImg3 = new javax.swing.JButton();
        btnImg4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        butNextGameInStore = new javax.swing.JButton();
        butPreviousGameInStore = new javax.swing.JButton();
        panelChangeGame = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        lblGameNameWhenHover = new javax.swing.JLabel();
        lblReviewInStore = new javax.swing.JLabel();
        lblGameTag = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        lblGameNameInStore1 = new javax.swing.JLabel();
        lblTagGameInStore1 = new javax.swing.JLabel();
        lblPriceGame1 = new javax.swing.JLabel();
        lblReleaseDate1 = new javax.swing.JLabel();
        imgMenuGame1 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lblTagGameInStore2 = new javax.swing.JLabel();
        lblGameNameInStore2 = new javax.swing.JLabel();
        lblPriceGame2 = new javax.swing.JLabel();
        imgMenuGame2 = new javax.swing.JLabel();
        lblReleaseDate2 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        lblTagGameInStore3 = new javax.swing.JLabel();
        lblGameNameInStore3 = new javax.swing.JLabel();
        lblPriceGame3 = new javax.swing.JLabel();
        imgMenuGame3 = new javax.swing.JLabel();
        lblReleaseDate3 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        lblTagGameInStore4 = new javax.swing.JLabel();
        lblGameNameInStore4 = new javax.swing.JLabel();
        lblPriceGame4 = new javax.swing.JLabel();
        imgMenuGame4 = new javax.swing.JLabel();
        lblReleaseDate4 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lblTagGameInStore5 = new javax.swing.JLabel();
        lblGameNameInStore5 = new javax.swing.JLabel();
        lblPriceGame5 = new javax.swing.JLabel();
        imgMenuGame5 = new javax.swing.JLabel();
        lblReleaseDate5 = new javax.swing.JLabel();
        scrollPanelGame = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        imgGame = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtTag = new javax.swing.JTextField();
        txtDeveloperInGameMenu = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jpanel99 = new javax.swing.JPanel();
        imgGameMain = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        imgGameList = new javax.swing.JPanel();
        btnImgGame1 = new javax.swing.JButton();
        btnImgGame2 = new javax.swing.JButton();
        btnImgGame3 = new javax.swing.JButton();
        btnImgGame4 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        btnPreviousImgGame = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        btnNextImgGame = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalReviews = new javax.swing.JLabel();
        lblOverralRating = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        lblGameName = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        lblPrice = new javax.swing.JLabel();
        butBuy = new javax.swing.JButton();
        scrollPanelReviewsGame = new javax.swing.JScrollPane();
        panelReviewsInGame = new javax.swing.JPanel();
        scrollPaneLibrary = new javax.swing.JScrollPane();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel36 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        infoUserGameInLibrary = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        imgGameInfo = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        butDetailGame = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        butChangeToReviewPost = new javax.swing.JButton();
        scrollPaneTransaction = new javax.swing.JScrollPane();
        jPanel43 = new javax.swing.JPanel();
        scrollPaneGamesGenre = new javax.swing.JScrollPane();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        lblGenre = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel67 = new javax.swing.JPanel();
        panelTransaction = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblGameNameInTransaction = new javax.swing.JLabel();
        lblPriceInTransaction = new javax.swing.JLabel();
        lblTagInTransaction = new javax.swing.JLabel();
        lblReleaseDateInTransaction = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblCashBeforePurchase = new javax.swing.JLabel();
        lblCashNeedToPurchase = new javax.swing.JLabel();
        lblCashAfterPurchase = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        btnPurchase = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btnConfirmCheck = new javax.swing.JCheckBox();
        panelPostReview = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        butYes = new javax.swing.JRadioButton();
        butNo = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtReview = new javax.swing.JTextArea();
        butPostReview = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        lblImgGameInReviewPost = new javax.swing.JLabel();
        lblGameNameInReviewPost = new javax.swing.JLabel();
        lblGameReleaseDateInReviewPost = new javax.swing.JLabel();
        butDeleteReview = new javax.swing.JButton();
        scrollPanelDevs = new javax.swing.JScrollPane();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        lblImgDev = new javax.swing.JLabel();
        lblDevName = new javax.swing.JLabel();
        panelListGameDev = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        comboBox = new javax.swing.JComboBox<>();
        Steam = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnshowInformation = new javax.swing.JMenuItem();
        btnAddBalance = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnSignOut = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(23, 29, 37));
        setPreferredSize(new java.awt.Dimension(1050, 532));

        jToolBar1.setBackground(new java.awt.Color(23, 29, 37));
        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        btnPreviousContainer.setBackground(new java.awt.Color(23, 29, 37));
        btnPreviousContainer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreviousContainer.setForeground(new java.awt.Color(255, 255, 255));
        btnPreviousContainer.setText("Previous");
        btnPreviousContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPreviousContainer.setFocusable(false);
        btnPreviousContainer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPreviousContainer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPreviousContainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousContainerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPreviousContainer);

        btnNextContainer.setBackground(new java.awt.Color(23, 29, 37));
        btnNextContainer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextContainer.setForeground(new java.awt.Color(255, 255, 255));
        btnNextContainer.setText("Next");
        btnNextContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNextContainer.setFocusable(false);
        btnNextContainer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNextContainer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNextContainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextContainerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNextContainer);

        btnStore.setBackground(new java.awt.Color(23, 29, 37));
        btnStore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStore.setForeground(new java.awt.Color(255, 255, 255));
        btnStore.setText("Store");
        btnStore.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnStore.setFocusable(false);
        btnStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStore);

        btnLibrary.setBackground(new java.awt.Color(23, 29, 37));
        btnLibrary.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLibrary.setForeground(new java.awt.Color(255, 255, 255));
        btnLibrary.setText("Library");
        btnLibrary.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLibrary.setFocusable(false);
        btnLibrary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLibrary.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLibrary);

        jPanel3.setBackground(new java.awt.Color(23, 29, 37));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel42.setBackground(new java.awt.Color(23, 29, 37));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel42);

        jPanel44.setBackground(new java.awt.Color(23, 29, 37));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel44.setLayout(flowLayout1);

        lblBalance.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(255, 255, 255));
        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBalance.setText("Số dư: 36.000.000 VND");
        lblBalance.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBalance.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel44.add(lblBalance);

        jPanel3.add(jPanel44);

        jToolBar1.add(jPanel3);

        mainContainer.setPreferredSize(new java.awt.Dimension(1050, 450));
        mainContainer.setLayout(new java.awt.CardLayout());

        scrollPanelStore.setPreferredSize(new java.awt.Dimension(1025, 600));

        jPanel2.setPreferredSize(new java.awt.Dimension(1050, 984));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel6.setBackground(new java.awt.Color(35, 58, 78));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 40));
        jPanel6.setPreferredSize(new java.awt.Dimension(1050, 492));

        jPanel10.setBackground(new java.awt.Color(0, 21, 40));
        jPanel10.setPreferredSize(new java.awt.Dimension(1050, 430));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(0, 21, 40));

        jPanel20.setBackground(new java.awt.Color(0, 21, 40));
        jPanel20.setPreferredSize(new java.awt.Dimension(357, 9));
        jPanel20.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        btnImg1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnImg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImg1MouseEntered(evt);
            }
        });
        btnImg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImg1ActionPerformed(evt);
            }
        });
        jPanel20.add(btnImg1);
        btnImg1.getAccessibleContext().setAccessibleName("game1");

        btnImg2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnImg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImg2ActionPerformed(evt);
            }
        });
        jPanel20.add(btnImg2);
        btnImg2.getAccessibleContext().setAccessibleName("gam1");
        btnImg2.getAccessibleContext().setAccessibleDescription("");

        btnImg3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnImg3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImg3ActionPerformed(evt);
            }
        });
        jPanel20.add(btnImg3);

        btnImg4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnImg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImg4ActionPerformed(evt);
            }
        });
        jPanel20.add(btnImg4);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Grand Theft Auto V");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setPreferredSize(new java.awt.Dimension(357, 32));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        jPanel10.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel17.setBackground(new java.awt.Color(0, 21, 40));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel6.setPreferredSize(new java.awt.Dimension(637, 2));

        jPanel47.setLayout(new java.awt.BorderLayout());

        butNextGameInStore.setBackground(new java.awt.Color(0, 21, 40));
        butNextGameInStore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butNextGameInStore.setForeground(new java.awt.Color(255, 255, 255));
        butNextGameInStore.setText(">");
        butNextGameInStore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        butNextGameInStore.setFocusPainted(false);
        butNextGameInStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butNextGameInStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNextGameInStoreActionPerformed(evt);
            }
        });
        jPanel47.add(butNextGameInStore, java.awt.BorderLayout.LINE_END);

        butPreviousGameInStore.setBackground(new java.awt.Color(0, 21, 40));
        butPreviousGameInStore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butPreviousGameInStore.setForeground(new java.awt.Color(255, 255, 255));
        butPreviousGameInStore.setText("<");
        butPreviousGameInStore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        butPreviousGameInStore.setFocusPainted(false);
        butPreviousGameInStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butPreviousGameInStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPreviousGameInStoreActionPerformed(evt);
            }
        });
        jPanel47.add(butPreviousGameInStore, java.awt.BorderLayout.LINE_START);

        panelChangeGame.setBackground(new java.awt.Color(0, 21, 40));
        panelChangeGame.setLayout(new java.awt.GridLayout(1, 0));
        jPanel47.add(panelChangeGame, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel10.add(jPanel17, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FEARTURED AND RECOMMENDED");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel6);

        jPanel4.setBackground(new java.awt.Color(35, 58, 78));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 40));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(149, 187, 212));
        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(149, 187, 212));

        lblGameNameWhenHover.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblGameNameWhenHover.setText("Grand Theft Auto V");

        lblReviewInStore.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReviewInStore.setText("jLabel4");

        lblGameTag.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblGameTag.setText("Tag");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGameNameWhenHover, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReviewInStore, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGameTag, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGameNameWhenHover, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblReviewInStore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGameTag, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel19.add(jPanel22, java.awt.BorderLayout.NORTH);

        jPanel27.setBackground(new java.awt.Color(149, 187, 212));
        jPanel27.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel27.setLayout(new java.awt.GridLayout(4, 1, 0, 20));
        jPanel27.add(jLabel12);
        jPanel27.add(jLabel13);
        jPanel27.add(jLabel14);
        jPanel27.add(jLabel15);

        jPanel19.add(jPanel27, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel19, java.awt.BorderLayout.LINE_END);

        jPanel21.setLayout(new java.awt.GridLayout(5, 1));

        jPanel23.setBackground(new java.awt.Color(28, 46, 62));

        lblGameNameInStore1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGameNameInStore1.setForeground(new java.awt.Color(255, 255, 255));
        lblGameNameInStore1.setText("Grand Theft Auto V");

        lblTagGameInStore1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTagGameInStore1.setForeground(new java.awt.Color(255, 255, 255));
        lblTagGameInStore1.setText("Tag");

        lblPriceGame1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceGame1.setForeground(new java.awt.Color(255, 255, 255));
        lblPriceGame1.setText("Giá tiền");

        lblReleaseDate1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReleaseDate1.setForeground(new java.awt.Color(255, 255, 255));
        lblReleaseDate1.setText("ngày phát hành");

        imgMenuGame1.setForeground(new java.awt.Color(255, 255, 255));
        imgMenuGame1.setText("jLabel12");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imgMenuGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lblTagGameInStore1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReleaseDate1))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lblGameNameInStore1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(lblPriceGame1)))
                .addGap(25, 25, 25))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGameNameInStore1)
                    .addComponent(lblPriceGame1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagGameInStore1)
                    .addComponent(lblReleaseDate1))
                .addGap(15, 15, 15))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMenuGame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        imgMenuGame1.getAccessibleContext().setAccessibleName("game1");

        jPanel21.add(jPanel23);
        jPanel23.getAccessibleContext().setAccessibleName("game1");
        jPanel23.getAccessibleContext().setAccessibleDescription("Grand Theft Auto V");

        jPanel24.setBackground(new java.awt.Color(28, 46, 62));

        lblTagGameInStore2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTagGameInStore2.setForeground(new java.awt.Color(255, 255, 255));
        lblTagGameInStore2.setText("Tag");

        lblGameNameInStore2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGameNameInStore2.setForeground(new java.awt.Color(255, 255, 255));
        lblGameNameInStore2.setText("Persona 5");

        lblPriceGame2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceGame2.setForeground(new java.awt.Color(255, 255, 255));
        lblPriceGame2.setText("Giá tiền");

        imgMenuGame2.setForeground(new java.awt.Color(255, 255, 255));
        imgMenuGame2.setText("jLabel12");

        lblReleaseDate2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReleaseDate2.setForeground(new java.awt.Color(255, 255, 255));
        lblReleaseDate2.setText("ngày phát hành");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imgMenuGame2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(lblTagGameInStore2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReleaseDate2))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(lblGameNameInStore2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addComponent(lblPriceGame2)))
                .addGap(25, 25, 25))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGameNameInStore2)
                    .addComponent(lblPriceGame2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagGameInStore2)
                    .addComponent(lblReleaseDate2))
                .addGap(14, 14, 14))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMenuGame2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        imgMenuGame2.getAccessibleContext().setAccessibleName("game2");

        jPanel21.add(jPanel24);
        jPanel24.getAccessibleContext().setAccessibleName("game2");
        jPanel24.getAccessibleContext().setAccessibleDescription("Persona 5");

        jPanel25.setBackground(new java.awt.Color(28, 46, 62));

        lblTagGameInStore3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTagGameInStore3.setForeground(new java.awt.Color(255, 255, 255));
        lblTagGameInStore3.setText("Tag");

        lblGameNameInStore3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGameNameInStore3.setForeground(new java.awt.Color(255, 255, 255));
        lblGameNameInStore3.setText("Inside The Backroom");

        lblPriceGame3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceGame3.setForeground(new java.awt.Color(255, 255, 255));
        lblPriceGame3.setText("Giá tiền");

        imgMenuGame3.setForeground(new java.awt.Color(255, 255, 255));
        imgMenuGame3.setText("jLabel12");

        lblReleaseDate3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReleaseDate3.setForeground(new java.awt.Color(255, 255, 255));
        lblReleaseDate3.setText("ngày phát hành");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imgMenuGame3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(lblTagGameInStore3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReleaseDate3))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(lblGameNameInStore3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addComponent(lblPriceGame3)))
                .addGap(25, 25, 25))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGameNameInStore3)
                    .addComponent(lblPriceGame3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagGameInStore3)
                    .addComponent(lblReleaseDate3))
                .addGap(15, 15, 15))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMenuGame3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel21.add(jPanel25);
        jPanel25.getAccessibleContext().setAccessibleName("game3");
        jPanel25.getAccessibleContext().setAccessibleDescription("Inside The Backroom");

        jPanel26.setBackground(new java.awt.Color(28, 46, 62));

        lblTagGameInStore4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTagGameInStore4.setForeground(new java.awt.Color(255, 255, 255));
        lblTagGameInStore4.setText("Tag");

        lblGameNameInStore4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGameNameInStore4.setForeground(new java.awt.Color(255, 255, 255));
        lblGameNameInStore4.setText("Raft");

        lblPriceGame4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceGame4.setForeground(new java.awt.Color(255, 255, 255));
        lblPriceGame4.setText("Giá tiền");

        imgMenuGame4.setForeground(new java.awt.Color(255, 255, 255));
        imgMenuGame4.setText("jLabel12");

        lblReleaseDate4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReleaseDate4.setForeground(new java.awt.Color(255, 255, 255));
        lblReleaseDate4.setText("ngày phát hành");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imgMenuGame4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(lblTagGameInStore4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReleaseDate4))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(lblGameNameInStore4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                        .addComponent(lblPriceGame4)))
                .addGap(25, 25, 25))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGameNameInStore4)
                    .addComponent(lblPriceGame4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagGameInStore4)
                    .addComponent(lblReleaseDate4))
                .addGap(14, 14, 14))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMenuGame4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel21.add(jPanel26);
        jPanel26.getAccessibleContext().setAccessibleName("game4");
        jPanel26.getAccessibleContext().setAccessibleDescription("Raft");

        jPanel28.setBackground(new java.awt.Color(28, 46, 62));

        lblTagGameInStore5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTagGameInStore5.setForeground(new java.awt.Color(255, 255, 255));
        lblTagGameInStore5.setText("Tag");

        lblGameNameInStore5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGameNameInStore5.setForeground(new java.awt.Color(255, 255, 255));
        lblGameNameInStore5.setText("Crime Simulator");

        lblPriceGame5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceGame5.setForeground(new java.awt.Color(255, 255, 255));
        lblPriceGame5.setText("Giá tiền");

        imgMenuGame5.setForeground(new java.awt.Color(255, 255, 255));
        imgMenuGame5.setText("jLabel12");

        lblReleaseDate5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReleaseDate5.setForeground(new java.awt.Color(255, 255, 255));
        lblReleaseDate5.setText("ngày phát hành");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imgMenuGame5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(lblTagGameInStore5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReleaseDate5))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(lblGameNameInStore5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                        .addComponent(lblPriceGame5)))
                .addGap(25, 25, 25))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGameNameInStore5)
                    .addComponent(lblPriceGame5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagGameInStore5)
                    .addComponent(lblReleaseDate5))
                .addGap(14, 14, 14))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMenuGame5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel21.add(jPanel28);
        jPanel28.getAccessibleContext().setAccessibleName("game5");
        jPanel28.getAccessibleContext().setAccessibleDescription("Crime Simulator");

        jPanel4.add(jPanel21, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        scrollPanelStore.setViewportView(jPanel2);

        mainContainer.add(scrollPanelStore, "cardStore");

        scrollPanelGame.setPreferredSize(new java.awt.Dimension(1025, 1142));

        jPanel1.setPreferredSize(new java.awt.Dimension(1025, 970));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(35, 58, 78));

        jPanel11.setBackground(new java.awt.Color(35, 58, 78));

        imgGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgGame, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
        );

        txtDescription.setEditable(false);
        txtDescription.setBackground(new java.awt.Color(35, 58, 78));
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setText("Experience entertainment blockbusters Grand Theft Auto V and Grand Theft Auto Online — now upgraded for a new generation with stunning visuals, faster loading, 3D audio, and more, plus exclusive content for GTA Online players.");
        txtDescription.setWrapStyleWord(true);
        txtDescription.setAutoscrolls(false);
        txtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtDescription);

        txtTag.setEditable(false);
        txtTag.setBackground(new java.awt.Color(35, 58, 78));
        txtTag.setForeground(new java.awt.Color(255, 255, 255));
        txtTag.setText("Tag");
        txtTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTagActionPerformed(evt);
            }
        });

        txtDeveloperInGameMenu.setEditable(false);
        txtDeveloperInGameMenu.setBackground(new java.awt.Color(35, 58, 78));
        txtDeveloperInGameMenu.setForeground(new java.awt.Color(255, 255, 255));
        txtDeveloperInGameMenu.setText("Developer: ");
        txtDeveloperInGameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeveloperInGameMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTag, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(txtDeveloperInGameMenu))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTag, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtDeveloperInGameMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel12.setBackground(new java.awt.Color(35, 58, 78));

        jpanel99.setBackground(new java.awt.Color(35, 58, 78));

        imgGameMain.setBackground(new java.awt.Color(35, 58, 78));
        imgGameMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jpanel99Layout = new javax.swing.GroupLayout(jpanel99);
        jpanel99.setLayout(jpanel99Layout);
        jpanel99Layout.setHorizontalGroup(
            jpanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel99Layout.createSequentialGroup()
                .addComponent(imgGameMain, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpanel99Layout.setVerticalGroup(
            jpanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel99Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(imgGameMain, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(35, 58, 78));
        jPanel30.setLayout(new java.awt.BorderLayout(10, 0));

        imgGameList.setBackground(new java.awt.Color(35, 58, 78));
        imgGameList.setLayout(new java.awt.GridLayout(1, 4, 5, 5));

        btnImgGame1.setBorder(null);
        btnImgGame1.setContentAreaFilled(false);
        btnImgGame1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgGame1.setFocusPainted(false);
        btnImgGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgGame1ActionPerformed(evt);
            }
        });
        imgGameList.add(btnImgGame1);

        btnImgGame2.setBorder(null);
        btnImgGame2.setContentAreaFilled(false);
        btnImgGame2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgGame2.setFocusPainted(false);
        btnImgGame2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgGame2ActionPerformed(evt);
            }
        });
        imgGameList.add(btnImgGame2);

        btnImgGame3.setBorder(null);
        btnImgGame3.setContentAreaFilled(false);
        btnImgGame3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgGame3.setFocusPainted(false);
        imgGameList.add(btnImgGame3);

        btnImgGame4.setBorder(null);
        btnImgGame4.setContentAreaFilled(false);
        btnImgGame4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgGame4.setFocusPainted(false);
        btnImgGame4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgGame4ActionPerformed(evt);
            }
        });
        imgGameList.add(btnImgGame4);

        jPanel30.add(imgGameList, java.awt.BorderLayout.CENTER);

        jPanel31.setLayout(new java.awt.GridLayout(1, 0));

        btnPreviousImgGame.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnPreviousImgGame.setText("<");
        btnPreviousImgGame.setFocusPainted(false);
        btnPreviousImgGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousImgGameActionPerformed(evt);
            }
        });
        jPanel31.add(btnPreviousImgGame);

        jPanel30.add(jPanel31, java.awt.BorderLayout.LINE_START);

        jPanel32.setLayout(new java.awt.GridLayout(1, 0));

        btnNextImgGame.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnNextImgGame.setText(">");
        btnNextImgGame.setFocusPainted(false);
        btnNextImgGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextImgGameActionPerformed(evt);
            }
        });
        jPanel32.add(btnNextImgGame);

        jPanel30.add(jPanel32, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jpanel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(35, 58, 78));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(35, 58, 78));

        jPanel15.setBackground(new java.awt.Color(35, 58, 78));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("OVERRAL:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTotalReviews.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalReviews.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalReviews.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalReviews.setText("jLabel16");
        lblTotalReviews.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblOverralRating.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblOverralRating.setForeground(new java.awt.Color(255, 255, 255));
        lblOverralRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOverralRating.setText("jLabel16");
        lblOverralRating.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalReviews, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOverralRating, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(lblOverralRating, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblTotalReviews, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel13, java.awt.BorderLayout.LINE_END);

        jPanel14.setBackground(new java.awt.Color(35, 58, 78));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel46.setBackground(new java.awt.Color(35, 58, 78));

        lblGameName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGameName.setForeground(new java.awt.Color(255, 255, 255));
        lblGameName.setText("Buy");

        jPanel48.setBackground(new java.awt.Color(35, 58, 78));
        jPanel48.setLayout(new java.awt.GridLayout(1, 2));

        lblPrice.setBackground(new java.awt.Color(35, 58, 78));
        lblPrice.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrice.setText("jLabel4");
        jPanel48.add(lblPrice);

        butBuy.setBackground(new java.awt.Color(35, 58, 78));
        butBuy.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        butBuy.setForeground(new java.awt.Color(255, 255, 255));
        butBuy.setText("Process");
        butBuy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        butBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuyActionPerformed(evt);
            }
        });
        jPanel48.add(butBuy);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGameName, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGameName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.add(jPanel46, java.awt.BorderLayout.PAGE_START);

        panelReviewsInGame.setBackground(new java.awt.Color(35, 58, 78));
        panelReviewsInGame.setLayout(new javax.swing.BoxLayout(panelReviewsInGame, javax.swing.BoxLayout.Y_AXIS));
        scrollPanelReviewsGame.setViewportView(panelReviewsInGame);

        jPanel14.add(scrollPanelReviewsGame, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8);

        scrollPanelGame.setViewportView(jPanel1);

        mainContainer.add(scrollPanelGame, "cardGame");

        scrollPaneLibrary.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPaneLibrary.setPreferredSize(new java.awt.Dimension(1050, 500));
        scrollPaneLibrary.setViewportView(jPanel29);

        jPanel29.setBackground(new java.awt.Color(36, 40, 47));
        jPanel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 100, 10));
        jPanel29.setPreferredSize(new java.awt.Dimension(1050, 530));
        jPanel29.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Games", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        jScrollPane2.setViewportView(jPanel36);

        //
        jPanel36.setBackground(new java.awt.Color(36, 40, 47));
        jPanel36.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 20));
        jPanel36.setPreferredSize(null);
        jPanel36.setLayout(new javax.swing.BoxLayout(jPanel36, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jPanel36);

        jPanel29.add(jScrollPane2, java.awt.BorderLayout.WEST);

        jPanel33.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 20));
        jPanel33.setPreferredSize(new java.awt.Dimension(713, 300));

        infoUserGameInLibrary.setBackground(new java.awt.Color(36, 40, 47));
        infoUserGameInLibrary.setPreferredSize(new java.awt.Dimension(720, 384));

        jPanel37.setBackground(new java.awt.Color(36, 40, 47));
        jPanel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 20));
        jPanel37.setPreferredSize(new java.awt.Dimension(726, 200));
        jPanel37.setLayout(new java.awt.GridLayout(1, 0));

        imgGameInfo.setBackground(new java.awt.Color(36, 40, 47));
        jPanel37.add(imgGameInfo);

        jPanel34.setBackground(new java.awt.Color(23, 29, 37));
        jPanel34.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 25));

        jPanel35.setBackground(new java.awt.Color(36, 40, 47));
        jPanel35.setLayout(new java.awt.GridLayout(1, 0));

        jPanel38.setBackground(new java.awt.Color(36, 40, 47));
        jPanel38.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        jButton1.setBackground(new java.awt.Color(36, 40, 47));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PLAY");
        jPanel38.add(jButton1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LAST PLAYED");
        jPanel38.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PLAY TIME");
        jPanel38.add(jLabel2);

        jPanel35.add(jPanel38);

        jPanel39.setBackground(new java.awt.Color(36, 40, 47));
        jPanel39.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        butDetailGame.setBackground(new java.awt.Color(36, 40, 47));
        butDetailGame.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        butDetailGame.setForeground(new java.awt.Color(255, 255, 255));
        butDetailGame.setText("Details");
        jPanel39.add(butDetailGame);

        jButton4.setBackground(new java.awt.Color(36, 40, 47));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Setting");
        jPanel39.add(jButton4);

        butChangeToReviewPost.setBackground(new java.awt.Color(36, 40, 47));
        butChangeToReviewPost.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        butChangeToReviewPost.setForeground(new java.awt.Color(255, 255, 255));
        butChangeToReviewPost.setText("Write a review");
        butChangeToReviewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butChangeToReviewPostActionPerformed(evt);
            }
        });
        jPanel39.add(butChangeToReviewPost);

        jPanel35.add(jPanel39);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout infoUserGameInLibraryLayout = new javax.swing.GroupLayout(infoUserGameInLibrary);
        infoUserGameInLibrary.setLayout(infoUserGameInLibraryLayout);
        infoUserGameInLibraryLayout.setHorizontalGroup(
            infoUserGameInLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoUserGameInLibraryLayout.createSequentialGroup()
                .addGroup(infoUserGameInLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        infoUserGameInLibraryLayout.setVerticalGroup(
            infoUserGameInLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoUserGameInLibraryLayout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoUserGameInLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(infoUserGameInLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel29.add(jPanel33, java.awt.BorderLayout.CENTER);

        scrollPaneLibrary.setViewportView(jPanel29);

        mainContainer.add(scrollPaneLibrary, "cardLibrary");

        jPanel43.setPreferredSize(new java.awt.Dimension(1025, 1140));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );

        scrollPaneTransaction.setViewportView(jPanel43);

        mainContainer.add(scrollPaneTransaction, "cardTransaction");

        jPanel49.setBackground(new java.awt.Color(35, 58, 78));
        jPanel49.setLayout(new java.awt.BorderLayout());

        jPanel50.setBackground(new java.awt.Color(35, 58, 78));
        jPanel50.setLayout(new java.awt.GridLayout(3, 3));

        jPanel52.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel52);

        jPanel53.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel53);

        jPanel54.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel54);

        jPanel55.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel55);

        jPanel56.setBackground(new java.awt.Color(35, 58, 78));
        jPanel56.setLayout(new java.awt.GridLayout(1, 0));

        lblGenre.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblGenre.setForeground(new java.awt.Color(255, 255, 255));
        lblGenre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenre.setText("Fps");
        jPanel56.add(lblGenre);

        jPanel50.add(jPanel56);

        jPanel57.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel57);

        jPanel58.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel58);

        jPanel59.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel59);

        jPanel60.setBackground(new java.awt.Color(35, 58, 78));

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel60);

        jPanel49.add(jPanel50, java.awt.BorderLayout.NORTH);

        jPanel67.setBackground(new java.awt.Color(35, 58, 78));
        jPanel67.setLayout(new javax.swing.BoxLayout(jPanel67, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane5.setViewportView(jPanel67);

        jPanel49.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        scrollPaneGamesGenre.setViewportView(jPanel49);

        mainContainer.add(scrollPaneGamesGenre, "cardGenre");

        panelTransaction.setPreferredSize(new java.awt.Dimension(1050, 388));
        panelTransaction.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(0, 21, 40));
        jPanel18.setPreferredSize(new java.awt.Dimension(297, 238));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel64.setBackground(new java.awt.Color(0, 21, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("PURCHASING ON STEAM");

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(0, 21, 40));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Once you've complepted this transaction, your payment method will be debited and you'll re-ceive an email massage confirming receipt of  your purchase.");
        jTextArea2.setBorder(null);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel64, java.awt.BorderLayout.PAGE_START);

        panelTransaction.add(jPanel18, java.awt.BorderLayout.EAST);

        jPanel61.setBackground(new java.awt.Color(0, 49, 96));
        jPanel61.setLayout(new java.awt.BorderLayout());

        jPanel62.setBackground(new java.awt.Color(0, 21, 40));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblGameNameInTransaction.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblGameNameInTransaction.setForeground(new java.awt.Color(255, 255, 255));

        lblPriceInTransaction.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceInTransaction.setForeground(new java.awt.Color(255, 255, 255));
        lblPriceInTransaction.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPriceInTransaction.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTagInTransaction.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTagInTransaction.setForeground(new java.awt.Color(255, 255, 255));

        lblReleaseDateInTransaction.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblReleaseDateInTransaction.setForeground(new java.awt.Color(255, 255, 255));
        lblReleaseDateInTransaction.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblReleaseDateInTransaction.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addComponent(lblGameNameInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPriceInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                        .addComponent(lblTagInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReleaseDateInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGameNameInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTagInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReleaseDateInTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel61.add(jPanel62, java.awt.BorderLayout.NORTH);

        jPanel63.setBackground(new java.awt.Color(0, 21, 40));
        jPanel63.setLayout(new java.awt.GridLayout(2, 1));

        jPanel68.setBackground(new java.awt.Color(0, 21, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số dư trước khi giao dịch:");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Số tiền mua game:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Số dư sau khi giao dịch");

        lblCashBeforePurchase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCashBeforePurchase.setForeground(new java.awt.Color(255, 255, 255));
        lblCashBeforePurchase.setText("jLabel29");

        lblCashNeedToPurchase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCashNeedToPurchase.setForeground(new java.awt.Color(255, 255, 255));
        lblCashNeedToPurchase.setText("jLabel30");

        lblCashAfterPurchase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCashAfterPurchase.setForeground(new java.awt.Color(255, 255, 255));
        lblCashAfterPurchase.setText("jLabel32");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCashNeedToPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(lblCashAfterPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCashBeforePurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCashBeforePurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblCashNeedToPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblCashAfterPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel63.add(jPanel68);

        jPanel69.setBackground(new java.awt.Color(0, 21, 40));

        btnPurchase.setBackground(new java.awt.Color(0, 163, 255));
        btnPurchase.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnPurchase.setForeground(new java.awt.Color(255, 255, 255));
        btnPurchase.setText("Purchase");
        btnPurchase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPurchase.setPreferredSize(new java.awt.Dimension(77, 54));
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Toi dong tinh");

        btnConfirmCheck.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConfirmCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmCheck.setText("Bạn đồng ý với Chính sách của Steam");

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmCheck)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addComponent(btnConfirmCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel63.add(jPanel69);

        jPanel61.add(jPanel63, java.awt.BorderLayout.CENTER);

        panelTransaction.add(jPanel61, java.awt.BorderLayout.CENTER);

        mainContainer.add(panelTransaction, "card7");

        panelPostReview.setBackground(new java.awt.Color(0, 49, 101));

        jPanel65.setBackground(new java.awt.Color(0, 49, 101));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Do you want to recommend to others ?");

        buttonGroup1.add(butYes);
        butYes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        butYes.setForeground(new java.awt.Color(255, 255, 255));
        butYes.setText("Yes");

        buttonGroup1.add(butNo);
        butNo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        butNo.setForeground(new java.awt.Color(255, 255, 255));
        butNo.setText("No");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butYes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butNo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butNo)
                    .addComponent(butYes)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jScrollPane4.setBorder(null);

        txtReview.setBackground(new java.awt.Color(0, 21, 40));
        txtReview.setColumns(20);
        txtReview.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtReview.setForeground(new java.awt.Color(255, 255, 255));
        txtReview.setLineWrap(true);
        txtReview.setRows(5);
        jScrollPane4.setViewportView(txtReview);

        butPostReview.setBackground(new java.awt.Color(0, 163, 255));
        butPostReview.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        butPostReview.setForeground(new java.awt.Color(255, 255, 255));
        butPostReview.setText("Post");

        jButton10.setBackground(new java.awt.Color(0, 163, 255));
        jButton10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Cancel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel66.setBackground(new java.awt.Color(0, 49, 101));

        lblImgGameInReviewPost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblGameNameInReviewPost.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblGameNameInReviewPost.setForeground(new java.awt.Color(255, 255, 255));
        lblGameNameInReviewPost.setText("jLabel26");

        lblGameReleaseDateInReviewPost.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblGameReleaseDateInReviewPost.setForeground(new java.awt.Color(255, 255, 255));
        lblGameReleaseDateInReviewPost.setText("jLabel26");

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGameNameInReviewPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGameReleaseDateInReviewPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblImgGameInReviewPost, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgGameInReviewPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(lblGameNameInReviewPost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGameReleaseDateInReviewPost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        butDeleteReview.setBackground(new java.awt.Color(0, 163, 255));
        butDeleteReview.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        butDeleteReview.setForeground(new java.awt.Color(255, 255, 255));
        butDeleteReview.setText("Delete");

        javax.swing.GroupLayout panelPostReviewLayout = new javax.swing.GroupLayout(panelPostReview);
        panelPostReview.setLayout(panelPostReviewLayout);
        panelPostReviewLayout.setHorizontalGroup(
            panelPostReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPostReviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPostReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelPostReviewLayout.createSequentialGroup()
                        .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPostReviewLayout.createSequentialGroup()
                        .addComponent(butDeleteReview, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butPostReview, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelPostReviewLayout.setVerticalGroup(
            panelPostReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPostReviewLayout.createSequentialGroup()
                .addGroup(panelPostReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPostReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(butDeleteReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butPostReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainContainer.add(panelPostReview, "card8");

        scrollPanelDevs.setViewportView(jPanel40);

        jPanel40.setBackground(new java.awt.Color(35, 58, 78));
        jPanel40.setPreferredSize(new java.awt.Dimension(1050, 500));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jPanel41.setBackground(new java.awt.Color(35, 58, 78));
        jPanel41.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jPanel41.setLayout(new java.awt.GridLayout(1, 2));

        jPanel45.setBackground(new java.awt.Color(35, 58, 78));

        lblImgDev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblDevName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblDevName.setForeground(new java.awt.Color(255, 255, 255));
        lblDevName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDevName.setText("jLabel20");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImgDev, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDevName, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblDevName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(lblImgDev, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel41.add(jPanel45);

        jPanel40.add(jPanel41, java.awt.BorderLayout.NORTH);

        panelListGameDev.setBackground(new java.awt.Color(35, 58, 78));
        panelListGameDev.setLayout(new javax.swing.BoxLayout(panelListGameDev, javax.swing.BoxLayout.Y_AXIS));
        jPanel40.add(panelListGameDev, java.awt.BorderLayout.CENTER);

        scrollPanelDevs.setViewportView(jPanel40);

        mainContainer.add(scrollPanelDevs, "cardDeveloper");

        jPanel5.setBackground(new java.awt.Color(35, 58, 78));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 0, 1, 2));
        jPanel5.setPreferredSize(new java.awt.Dimension(1025, 26));
        jPanel5.setLayout(new java.awt.BorderLayout());

        comboBox.setBackground(new java.awt.Color(52, 64, 79));
        comboBox.setForeground(new java.awt.Color(255, 255, 255));
        comboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        comboBox.setPreferredSize(new java.awt.Dimension(200, 22));
        comboBox.setRequestFocusEnabled(false);
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        jPanel5.add(comboBox, java.awt.BorderLayout.LINE_END);

        jMenu1.setText("Steam");

        btnshowInformation.setText("Information");
        btnshowInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowInformationActionPerformed(evt);
            }
        });
        jMenu1.add(btnshowInformation);

        btnAddBalance.setText("Add social credits");
        btnAddBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBalanceActionPerformed(evt);
            }
        });
        jMenu1.add(btnAddBalance);
        jMenu1.add(jSeparator1);

        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });
        jMenu1.add(btnSignOut);

        Steam.add(jMenu1);

        jMenu2.setText("Settings");
        Steam.add(jMenu2);

        setJMenuBar(Steam);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(mainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void initTestSearch(){
        model = new DefaultComboBoxModel<>();
        comboBox.setModel(model);
        //comboBox.setRenderer(new ComboboxRender());
        comboBox.setEditable(true);
        
        
        
        
        comboBox.setEditor(new BasicComboBoxEditor() {
            @Override
            public void setItem(Object anObject) {
                // Không cập nhật lại text trong editor để tránh autofill
            }
        });
        
        // Lấy component editor (JTextField)
        editor = (JTextField) comboBox.getEditor().getEditorComponent();
        SwingUtilities.invokeLater(() -> {
            jButton1.requestFocusInWindow(); // hoặc frame.requestFocus();
        });
        
        
        
        
        editor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Khi click chuột (nhấn + thả)
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!editor.getText().trim().isEmpty()){
                    searchTest();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) {
                // Khi rời khỏi editor, đợi 300ms rồi mới bỏ focus
                new javax.swing.Timer(300, evt -> {
                    // Kiểm tra lại — nếu sau 300ms mà chuột vẫn không quay lại editor hoặc popup
                    if (!isMouseOverComboPopup(comboBox)) {
                        //editor.setFocusable(false);
                        jButton1.transferFocus(); // hoặc requestFocusInWindow() cho component khác
                        
                    }
                    ((javax.swing.Timer) evt.getSource()).stop();
                }).start();
            }
        });
        
        
        
        // DocumentListener: mỗi thay đổi restart timer; bỏ qua khi updatingModel = true
        editor.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override public void insertUpdate(DocumentEvent e) { searchTest();}
            @Override public void removeUpdate(DocumentEvent e) { searchTest();}
            @Override public void changedUpdate(DocumentEvent e) { /* plain text không dùng */ }
        });
        
        
        

        // Ẩn popup khi mất focus (đợi 50ms để click lên popup được xử lý)
        editor.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                SwingUtilities.invokeLater(() -> comboBox.hidePopup());
            }
        });
        
        
        // thêm listener cho mỗi item có trong phần tìm kiếm
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

                // 1. Bỏ qua nếu model đang tự cập nhật
                if (updatingModel) { 
                    return;
                }

                // 2. Chỉ xử lý khi người dùng chọn (không phải gõ Enter)
                if ("comboBoxChanged".equals(e.getActionCommand())) {

                    Object selected = comboBox.getSelectedItem();
                    
                    

                    // 3. Kiểm tra xem có phải là một đối tượng GameInfo không
                    if (selected instanceof Game) {

                        // Ép kiểu nó về GameInfo
                        Game selectedGame = (Game) selected;
                        if (selectedGame.getName().equals("Not Found")){return;}
                        // --- Đây là nơi bạn xử lý logic ---
                        // Giờ bạn có cả ID và Tên!
                        //System.out.println("Người dùng đã chọn: " + selectedGame.getName());
                        //System.out.println("ID của game là: " + selectedGame.getGameID());
                        editor.setText("");
                        setScaleImage(imgGame, "/game" + selectedGame.getId() +"/header.jpg", false);
                        initGameMenu(selectedGame, true);
                        c1.show(mainContainer, "cardGame");
                        
                        SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                            addPurchaseStatusToGame(selectedGame);
                            addDeveloperInteractable(selectedGame);
                            addReviewsInGameMenu(selectedGame);
                        });

                        // 4. Ẩn popup sau khi xử lý xong
                        comboBox.hidePopup();
                        

                    }
                    else if (selected instanceof Category){
                        // Ép kiểu nó về GameInfo
                        Category selectedGenre = (Category) selected;
                        if (selectedGenre.getName().equals("Not Found")){return;}
                        // --- Đây là nơi bạn xử lý logic ---
                        // Giờ bạn có cả ID và Tên!
                        //System.out.println("Người dùng đã chọn: " + selectedGame.getName());
                        //System.out.println("ID của game là: " + selectedGame.getGameID());
                        editor.setText("");
                        lblGenre.setText(selectedGenre.getName().toUpperCase());
                        initGameInGenre(selectedGenre, true);
                        c1.show(mainContainer, "cardGenre");
                    } 
                    
                    else if (selected instanceof Developer){
                        // Ép kiểu nó về GameInfo
                        Developer selectedDeveloper = (Developer) selected;
                        if (selectedDeveloper.getName().equals("Not Found")){return;}
                        
                        editor.setText("");
                        //lblGenre.setText(selectedDeveloper.getName().toUpperCase());
                        initGameInDev(selectedDeveloper, true);
                        c1.show(mainContainer, "cardDeveloper");
                    } 
                    
                    else if (selected != null && selected.toString().equals("Not Found")) {

                        // 5. Xử lý riêng trường hợp "Not Found"
                        System.out.println("Không tìm thấy kết quả");

                        // (Bạn có thể cân nhắc ẩn popup ở đây nếu muốn)
                        // comboBox.hidePopup(); 
                    }
                    
                }
            }
        });
        
        
       
        
    }
    
    

    private void searchTest(){
                SwingUtilities.invokeLater(() -> {
                    if (updatingModel) return; // tránh đệ quy do combo.setSelectedItem()
                    updatingModel = true;
                    
                    String inputString = editor.getText().trim().toLowerCase();
                    if (inputString.isEmpty()){
                        comboBox.hidePopup();
                        updatingModel = false;
                        return;
                    }
//                    java.util.List<GameInfo> filtered = items.stream()
//                    .filter(s -> s.getName().toLowerCase().contains(inputString))
//                    .collect(Collectors.toList());
//                    
//                    java.util.List<GenreInfo> filteredGen = itemsGenre.stream()
//                    .filter(s -> s.getName().toLowerCase().contains(inputString))
//                    .collect(Collectors.toList());
                    
                    model.removeAllElements();
//                    if(filtered.isEmpty() && filteredGen.isEmpty()){ model.addElement(new GameInfo("Not Found",-1, 0.0,"","", ""));}
//                    else {
//                        gameFoundViaName = gameRepository.findByName(inputString);
//                        for (GameInfo s : filtered) model.addElement(s);
//                        for (GenreInfo s: filteredGen){model.addElement(s);}
//                    }
                    //if (!filtered.isEmpty()) comboBox.showPopup();
                    //else comboBox.hidePopup();
                    gameFoundViaName = gameRepository.findByNameContainingIgnoreCase(inputString);
                    for (Game s:gameFoundViaName){
                        model.addElement(s);
                    }
                    java.util.List<Category> categoryFoundViaName = categoryRepository.findByNameContaining(inputString);
                    for(Category v:categoryFoundViaName){
                        model.addElement(v);
                    }
                    java.util.List<Developer> developerFoundViaName = developerRepository.findByName(inputString);
                    for(Developer v : developerFoundViaName){
                        model.addElement(v);
                    }
                    // kiem tra xem thu co tim thay khong
                    if(model.getSize() == 0){
                        model.addElement(new Category(-1, "Not Found"));
                    }
                    
                    // giới hạn số dòng trong popup
                    if (model.getSize() > 8){
                        comboBox.setMaximumRowCount(8); 
                    }
                    else{
                        comboBox.setMaximumRowCount(model.getSize());
                    }
                    comboBox.showPopup();
                    comboBox.getEditor().setItem(editor.getText());
                    updatingModel = false;
                });
                
            }
    
    private boolean isMouseOverComboPopup(JComboBox<?> comboBox) {
        ComboPopup popup = (ComboPopup) comboBox.getUI().getAccessibleChild(comboBox, 0);
        if (popup == null) return false;

        JList<?> list = popup.getList();
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mousePos, list);

        return list.contains(mousePos);
    }
    
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
        jPanel36.removeAll();
        
        dispose(); 
        new login().setVisible(true);
        
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreActionPerformed
        // TODO add your handling code here:
        if (selectedButInJTool == btnStore){}
        else{
            selectedButInJTool.setForeground(Color.WHITE);
            btnStore.setForeground(Color.decode("#00A3FF"));
            selectedButInJTool = btnStore;
        }
        dll.cutAfter(currentNode);
        dll.addLast(new storeDLL());
        currentNode = dll.getTail();
        c1.show(mainContainer, "cardStore");
        
    }//GEN-LAST:event_btnStoreActionPerformed

    private void btnLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryActionPerformed
        // TODO add your handling code here:
        if (selectedButInJTool == btnLibrary){}
        else{
            selectedButInJTool.setForeground(Color.WHITE);
            btnLibrary.setForeground(Color.decode("#00A3FF"));
            selectedButInJTool = btnLibrary;
        }
        dll.cutAfter(currentNode);
        dll.addLast(new libraryDLL());
        currentNode = dll.getTail();
        c1.show(mainContainer, "cardLibrary");
    }//GEN-LAST:event_btnLibraryActionPerformed

    private void txtTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTagActionPerformed

    private void initStore(){
        setScaleImage(imgGame, "/game1/header.jpg", true);
        setScaleImage(jLabel6, "/game1/header.jpg", true);
        
        
        
        setScaleImage(imgMenuGame1, "/game1/header.jpg", true);
        setScaleImage(imgMenuGame2, "/game2/header.jpg", true);
        setScaleImage(imgMenuGame3, "/game3/header.jpg", true);
        setScaleImage(imgMenuGame4, "/game4/header.jpg", true);
        setScaleImage(imgMenuGame5, "/game5/header.jpg", true);
        
        setScaleImage(jLabel12, "/game1/2.jpg", true);
        setScaleImage(jLabel13, "/game1/3.jpg", true);
        setScaleImage(jLabel14, "/game1/4.jpg", true);
        setScaleImage(jLabel15, "/game1/5.jpg", true);
        //setScaleImage(imgMenuGame2, "/persona5/header");
        //jPanel23.addMouseListener(new );
        setScaleImageBut(btnImg1, "/game1/2.jpg", true);
        setScaleImageBut(btnImg2, "/game1/3.jpg", true);
        setScaleImageBut(btnImg3, "/game1/4.jpg", true);
        setScaleImageBut(btnImg4, "/game1/5.jpg", true);
        
        
        addChangeGameButInStore(gameQuerry8);
        
        String categorys;
        
        
        
        categorys = gameRepository.findGenre(gameQuerry8.get(0).getGameId());
        lblGameNameInStore1.setText(gameQuerry8.get(0).getName());
        lblPriceGame1.setText(Double.toString(gameQuerry8.get(0).getPrice()) + " VND");
        lblTagGameInStore1.setText("Tag: " + categorys);
        jPanel23.getAccessibleContext().setAccessibleName(categorys);
        lblReleaseDate1.setText(sdf.format(gameQuerry8.get(0).getReleaseDate()));
        
        categorys = gameRepository.findGenre(gameQuerry8.get(1).getGameId());
        lblGameNameInStore2.setText(gameQuerry8.get(1).getName());
        lblPriceGame2.setText(Double.toString(gameQuerry8.get(1).getPrice()) + " VND");
        jPanel24.getAccessibleContext().setAccessibleName(categorys);
        lblTagGameInStore2.setText("Tag: " + categorys);
        lblReleaseDate2.setText(sdf.format(gameQuerry8.get(1).getReleaseDate()));
        
        categorys = gameRepository.findGenre(gameQuerry8.get(2).getGameId());
        lblGameNameInStore3.setText(gameQuerry8.get(2).getName());
        lblPriceGame3.setText(Double.toString(gameQuerry8.get(2).getPrice()) + " VND");
        jPanel25.getAccessibleContext().setAccessibleName(categorys);
        lblTagGameInStore3.setText("Tag: " + categorys);
        lblReleaseDate3.setText(sdf.format(gameQuerry8.get(2).getReleaseDate()));
        
        categorys = gameRepository.findGenre(gameQuerry8.get(3).getGameId());
        lblGameNameInStore4.setText(gameQuerry8.get(3).getName());
        lblPriceGame4.setText(Double.toString(gameQuerry8.get(3).getPrice()) + " VND");
        jPanel26.getAccessibleContext().setAccessibleName(categorys);
        lblTagGameInStore4.setText("Tag: " + categorys);
        lblReleaseDate4.setText(sdf.format(gameQuerry8.get(3).getReleaseDate()));
       
        categorys = gameRepository.findGenre(gameQuerry8.get(4).getGameId());
        lblGameNameInStore5.setText(gameQuerry8.get(4).getName());
        lblPriceGame5.setText(Double.toString(gameQuerry8.get(4).getPrice()) + " VND");
        jPanel28.getAccessibleContext().setAccessibleName(categorys);
        lblTagGameInStore5.setText("Tag: " + categorys);
        lblReleaseDate5.setText(sdf.format(gameQuerry8.get(4).getReleaseDate()));
        
        calculatReviewsForGameInStore(gameQuerry8.get(0), true);               
        lblReviewInStore.setText(ratingFirGameInStore.get(0));    
        calculateRatingForGameInStore(gameQuerry8);
        resetHoverForPanelGameInStore((JPanel) jPanel23);
    }
    
    private void calculateRatingForGameInStore(java.util.List<Game> gameQuerry8){
        
        new SwingWorker<Boolean, Void>() {
                @Override
                protected Boolean doInBackground() throws Exception {
                    for (int i = 1; i < 5; i ++){
                        calculatReviewsForGameInStore(gameQuerry8.get(i), false);
                    }
                    return true;
                }

                @Override
                protected void done() {
                    try {
                        boolean status = get();
                    } catch (Exception e) {
                        
                    }
                }
            }.execute();
    }
    
    private void calculatReviewsForGameInStore(Game game, boolean firstInit){
        if(firstInit){
            java.util.List<ReviewWithUser> firstGameReivews = reviewRepository.findByGameId(game.getGameId());
            int positiveReviews = 0;
            int totalReviews = 0;
            for (ReviewWithUser s : firstGameReivews){
                totalReviews += 1;
                if (s.getRating().equals("1")){positiveReviews += 1;};
            }
            ratingFirGameInStore.add(calculateRating(totalReviews, positiveReviews, true) + " (" + Integer.toString(totalReviews) + ")");
            return;
        }
        
    new SwingWorker<java.util.List<ReviewWithUser>, Void>() {
                @Override
                protected java.util.List<ReviewWithUser> doInBackground() throws Exception {
                    return reviewRepository.findByGameId(game.getGameId());
                }

                @Override
                protected void done() {
                    try {
                        int positiveReviews = 0;
                        int totalReviews = 0;
                        java.util.List<ReviewWithUser> gameReviews = get();
                        for (ReviewWithUser s : gameReviews){
                            totalReviews += 1;
                            if (s.getRating().equals("1")){positiveReviews += 1;};
                        }
                        ratingFirGameInStore.add(calculateRating(totalReviews, positiveReviews, true) + " (" + Integer.toString(totalReviews) + ")");
                        //lblOverralRating.setText(calculateRating(totalReviews, positiveReviews));
                    } catch (Exception e) {
                        
                    }
                }
            }.execute();
    }
    
    private void addChangeGameButInStore(java.util.List<Game> lstGame){
        for(int i = 0; i < lstGame.size(); i ++){
            Game s = lstGame.get(i);
            JButton butChangeGame = new JButton("");
            butChangeGame.setBackground(Color.getColor("1D3F5C"));
            if (i == 0){
                selectedButtonGameInStore = butChangeGame;
                selectedButtonGameInStoreIndex = 0;
                selectedButtonGameInStore.setBorderPainted(true);
                selectedButtonGameInStore.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            }
            butChangeGame.setFocusPainted(false);
            butChangeGame.getAccessibleContext().setAccessibleDescription(Integer.toString(i));
//            butChangeGame.addMouseListener(new MouseAdapter(){
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    jLabel7.setText(s.getName());
//                    if(jLabel6.getMouseListeners().length != 0){
//                        jLabel16.removeMouseListener(jLabel6.getMouseListeners()[0]);
//                    }
//                    jLabel6.addMouseListener(new MouseAdapter(){
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            initGameMenu(s);
//                            c1.show(mainContainer, "card3");
//                        }
//                        
//                    });
//                    setScaleImage(jLabel6, "/game" + s.getId() + "/header.jpg");
//                    setScaleImageBut(btnImg1, "/game" + s.getId() + "/2.jpg");
//                    setScaleImageBut(btnImg2, "/game" + s.getId() + "/3.jpg");
//                    setScaleImageBut(btnImg3, "/game" + s.getId() + "/4.jpg");
//                    setScaleImageBut(btnImg4, "/game" + s.getId() + "/5.jpg");
//                }
//            });
            butChangeGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    if (selectedButtonGameInStoreIndex == Integer.parseInt(butChangeGame.getAccessibleContext().getAccessibleDescription())){
                    
                    }
                    else if(selectedButtonGameInStoreIndex != Integer.parseInt(butChangeGame.getAccessibleContext().getAccessibleDescription())){
                        selectedButtonGameInStore.setBorderPainted(false);
                        selectedButtonGameInStore.setBorder(null);
                        butChangeGame.setBorderPainted(true);
                        butChangeGame.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
                        selectedButtonGameInStore = butChangeGame;
                        selectedButtonGameInStoreIndex = Integer.parseInt(butChangeGame.getAccessibleContext().getAccessibleDescription());
                    }
                    
                    
                    
                    jLabel7.setText(s.getName());

                    setScaleImage(jLabel6, "/game" + s.getId() + "/header.jpg", true);
                    setScaleImageBut(btnImg1, "/game" + s.getId() + "/2.jpg", true);
                    setScaleImageBut(btnImg2, "/game" + s.getId() + "/3.jpg", true);
                    setScaleImageBut(btnImg3, "/game" + s.getId() + "/4.jpg", true);
                    setScaleImageBut(btnImg4, "/game" + s.getId() + "/5.jpg", true);
                    
//                    for (MouseListener mwl : jLabel6.getMouseListeners()) {
//                        jLabel6.removeMouseListener(mwl);
//                    }
//                    
//                    jLabel6.addMouseListener(new MouseListener(){
//                        @Override
//                        public void mousePressed(MouseEvent e) {
//                            initGameMenu(s, true);
//                            c1.show(mainContainer, "cardGame");
//                            SwingUtilities.invokeLater(() -> {
//                            // Gọi hàm load data
//                            addPurchaseStatusToGame(s);
//                            addDeveloperInteractable(s);
//                            addReviewsInGameMenu(s);
//                        });
//                            
//                        }
//
//                        @Override
//                        public void mouseClicked(MouseEvent e) {}
//                        @Override
//                        public void mouseReleased(MouseEvent e) {}
//                        
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//                            jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//                        }
//                        @Override
//                        public void mouseExited(MouseEvent e) {}
//                        
//                    });
                    
                    
                }
            });
            panelChangeGame.add(butChangeGame);
        }
    }
    
    private void initGameMenu(Game game, boolean updateNode){
        if(selectedButInJTool != btnStore){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnStore;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
        }
        
        if (updateNode){
            dll.cutAfter(currentNode);
            dll.addLast(game);
            currentNode = dll.getTail();
            scrollPanelGame.getVerticalScrollBar().setValue(0);
        }
        
        clearSelection();
        selectedButton = null;
        //jPanel30.setSize(new Dimension(226, 88));
        //jPanel30.setPreferredSize(new Dimension(226, 88));
        setScaleImage(imgGameMain, "/game" + game.getId()+ "/header.jpg", false);
        setScaleImage(imgGame, "/game" + game.getId()+ "/header.jpg", false);
        setScaleImageBut(btnImgGame1, "/game" + game.getId()+ "/2.jpg", false);
        setScaleImageBut(btnImgGame2, "/game" + game.getId()+ "/3.jpg", false);
        setScaleImageBut(btnImgGame3, "/game" + game.getId()+ "/4.jpg", false);
        setScaleImageBut(btnImgGame4, "/game" + game.getId()+ "/5.jpg", false);
        txtDescription.setText(game.getDescription());
        resetButtonListeners(btnImgGame1, btnImgGame2, btnImgGame3, btnImgGame4); // reset listener vi neu khong reset se ghi de len
        
        // them listener moi
        addClickEffect(btnImgGame1, "/game" + game.getId()+ "/2.jpg");
        addClickEffect(btnImgGame2, "/game" + game.getId()+ "/3.jpg");
        addClickEffect(btnImgGame3, "/game" + game.getId()+ "/4.jpg");
        addClickEffect(btnImgGame4, "/game" + game.getId()+ "/5.jpg");
        lblGameName.setText("Buy " + game.getName());
        lblPrice.setText(Double.toString(game.getPrice()) + " VND");
        //selectedButton = btnImgGame1;
        for (ActionListener al : butBuy.getActionListeners()) {
                    butBuy.removeActionListener(al);
        }
//        if (!gameUserPurchasedTest.isEmpty()){
//            for(GameInfo s : gameUserPurchasedTest){
//                    if(s.getId() == game.getId()){
//                        alreadyPurchased = true;
//                    }
//            }
//        }
        
//        java.util.List<String> testString = gameRepository.findGenre(game.getGameId());
//        txtTag.setText("Tag: "+ String.join(", ", testString));
          txtTag.setText("Tag: " + gameRepository.findGenre(game.getGameId()));
          //addPurchaseStatusToGame(game);
    }
    
    
    private void addPurchaseStatusToGame(Game game){
//        boolean alreadyPurchased = containRepository.isGameOwnedByUser(userInfo.getUserId(), game.getGameId());
//        if (alreadyPurchased == true){
//                butBuy.setText("In Library");
//                butBuy.addMouseListener(new MouseAdapter(){
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    //if (){}
//                    c1.show(mainContainer, "cardLibrary");
//                }
//            });
//        }
//        else {
//            
//            butBuy.setText("Process");
//            butBuy.addMouseListener(new MouseAdapter(){
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    //if (){}
//                    initTransaction(game);
//                    c1.show(mainContainer, "card7");
//                }
//
//            });
//        }
        
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                    return containRepository.isGameOwnedByUser(userInfo.getUserId(), game.getGameId());
                }
            
            @Override
            protected void done() {
                try{
                    boolean alreadyPurchased = get();
                    if (alreadyPurchased){
                        butBuy.setText("In Library");
                        butBuy.addActionListener(e -> {
                            c1.show(mainContainer, "cardLibrary");
                        });
                    }
                    else {

                        butBuy.setText("Process");
                        butBuy.addActionListener(e -> {
                            initTransaction(game);
                            c1.show(mainContainer, "card7");
                        });
                    }
                }
                catch (InterruptedException e) {
                    System.out.println("Task cancelled");
                    e.printStackTrace();
                    butBuy.setText("Error");
                    butBuy.setEnabled(false);
                } 
                catch (ExecutionException e) {
                    System.err.println("Error checking ownership");
                    e.printStackTrace();
                    butBuy.setText("Error");
                    butBuy.setEnabled(false);
                }
            }
            
        };
        worker.execute();
    }
    private void addDeveloperInteractable(Game game){
        Developer nameDev = developerRepository.getDeveloperViaGame(game.getGameId());
        if (nameDev == null){
            JOptionPane.showMessageDialog(mainContainer, "Đã xảy ra lỗi", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if (txtDeveloperInGameMenu.getMouseListeners().length != 0){
                txtDeveloperInGameMenu.removeMouseListener(butBuy.getMouseListeners()[0]);
            }
            txtDeveloperInGameMenu.setText("Developer: "+nameDev.getDevName());
            txtDeveloperInGameMenu.addMouseListener(new MouseListener(){
                @Override
                public void mousePressed(MouseEvent e) {
                    initGameInDev(nameDev, true);
                    c1.show(mainContainer, "cardDeveloper");
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    txtDeveloperInGameMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseClicked(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });
            
        }
    }
    
    private void addReviewsInGameMenu(Game game){
//            panelReviewsInGame.removeAll();
//            int positiveReviews = 0;
//            int totalReviews = 0;
//            java.util.List<ReviewWithUser> gameReviews = reviewRepository.findByGameId(game.getGameId());
//            for (ReviewWithUser s : gameReviews){
//                totalReviews += 1;
//                if (s.getRating().equals("1")){positiveReviews += 1;}
//                JPanel reviewGame = new reviewInGame(s.getUserName(), s.getRating(), s.getComment());
//                Dimension prefSize = reviewGame.getPreferredSize();
//                reviewGame.setMaximumSize(new Dimension(Integer.MAX_VALUE, prefSize.height));
//                reviewGame.setBorder(new RoundedBorder(10, Color.BLACK, 2));
//                panelReviewsInGame.add(reviewGame);
//                panelReviewsInGame.add(Box.createVerticalStrut(7));
//            }
            
            
            //bi y tuong
            panelReviewsInGame.removeAll();
            panelReviewsInGame.revalidate();
            panelReviewsInGame.repaint();
    
            new SwingWorker<java.util.List<ReviewWithUser>, Void>() {
                @Override
                protected java.util.List<ReviewWithUser> doInBackground() throws Exception {
                    return reviewRepository.findByGameId(game.getGameId());
                }

                @Override
                protected void done() {
                    try {
                        int positiveReviews = 0;
                        int totalReviews = 0;
                        java.util.List<ReviewWithUser> gameReviews = get();
                        for (ReviewWithUser s : gameReviews){
                            totalReviews += 1;
                            if (s.getRating().equals("1")){positiveReviews += 1;}
                            JPanel reviewGame = new reviewInGame(s.getUserName(), s.getRating(), s.getComment());
                            Dimension prefSize = reviewGame.getPreferredSize();
                            reviewGame.setMaximumSize(new Dimension(Integer.MAX_VALUE, prefSize.height));
                            reviewGame.setBorder(new RoundedBorder(10, Color.BLACK, 2));
                            panelReviewsInGame.add(reviewGame);
                            panelReviewsInGame.add(Box.createVerticalStrut(7));
                        }
                        panelReviewsInGame.revalidate();
                        panelReviewsInGame.repaint();
                        lblOverralRating.setText(calculateRating(totalReviews, positiveReviews, false));
                    } catch (Exception e) {
                        
                    }
                }
            }.execute();
    }
    
    private String calculateRating(int totalReviews, int positiveReviews, boolean forGameInStore){
        
        double percentage = ((double) positiveReviews / totalReviews) * 100;
        if (!forGameInStore){
            lblTotalReviews.setText(Integer.toString(totalReviews) + " reviews");
        }
        if(totalReviews < 3){
            return "No Rating Yet";
        }
        if (percentage >= 95) return "Overwhelmingly Positive";
        if (percentage >= 80) return "Very Positive";
        if (percentage >= 70) return "Mostly Positive";
        if (percentage >= 40) return "Mixed";
        if (percentage >= 20) return "Mostly Negative";
        return "Very Negative";
    }
    
    private void resetButtonListeners(JButton... buttons) {
    for (JButton btn : buttons) {
        for (MouseListener ml : btn.getMouseListeners()) {
            btn.removeMouseListener(ml);
        }
        btn.setBorder(null);
    }
}
    
    private void addClickEffect(JButton comp, String path) {
        comp.setPreferredSize(comp.getPreferredSize());
        comp.setMaximumSize(comp.getPreferredSize());
        comp.setMinimumSize(comp.getPreferredSize());
        
        for(MouseListener ml : comp.getMouseListeners()){
            comp.removeMouseListener(ml);
        }
        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if (selectedButton != null && selectedButton != comp) {
                    // Bỏ chọn cái cũ
                    selectedButton.setBorderPainted(false);
                    selectedButton.setBorder(null);
                                // cho phép trong suốt
                    
                }

                if (selectedButton == comp) {
                    // Click lại chính nó => bỏ chọn
                    //comp.setBackground(Color.LIGHT_GRAY);
                    selectedButton = null;
                } else {
                    // Chọn cái mới
                    setScaleImage(imgGameMain, path, false);
                    comp.setBorderPainted(true);
                    comp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
                    selectedButton = comp;
                }
            }
        });
    }
    
    
    private void clearSelection() {
    if (selectedButton == null) return;

    Object ob = selectedButton.getClientProperty("origBorder");
    Object obp = selectedButton.getClientProperty("origBorderPainted");
    Object ofp = selectedButton.getClientProperty("origFocusPainted");
    Object ocf = selectedButton.getClientProperty("origContentAreaFilled");
    Object opo = selectedButton.getClientProperty("origOpaque");
    Object obg = selectedButton.getClientProperty("origBackground");

    if (ob instanceof javax.swing.border.Border) {
        selectedButton.setBorder((javax.swing.border.Border) ob);
    } else {
        selectedButton.setBorder(null);
    }

    if (obp instanceof Boolean) selectedButton.setBorderPainted((Boolean) obp);
    if (ofp instanceof Boolean) selectedButton.setFocusPainted((Boolean) ofp);
    if (ocf instanceof Boolean) selectedButton.setContentAreaFilled((Boolean) ocf);
    if (opo instanceof Boolean) selectedButton.setOpaque((Boolean) opo);
    if (obg instanceof Color) selectedButton.setBackground((Color) obg);
    
    
    
   
    
    selectedButton.setIcon(null);
    // Xóa các client properties (tuỳ chọn)
    selectedButton.putClientProperty("origBorder", null);
    selectedButton.putClientProperty("origBorderPainted", null);
    selectedButton.putClientProperty("origFocusPainted", null);
    selectedButton.putClientProperty("origContentAreaFilled", null);
    selectedButton.putClientProperty("origOpaque", null);
    selectedButton.putClientProperty("origBackground", null);
    //System.out.println(selectedButton);
    selectedButton = null;
}
    
    private void btnImg3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImg3ActionPerformed
        // TODO add your handling code here:
        Icon icon = btnImg3.getIcon();
        String path = "";
//        if (icon instanceof ImageIcon) {
//            path = ((ImageIcon) icon).getDescription();
//        }
        path = (String) btnImg3.getClientProperty("img_path");
        setScaleImage(jLabel6, path, true);
    }//GEN-LAST:event_btnImg3ActionPerformed

    private void btnImg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImg4ActionPerformed
        // TODO add your handling code here:
        Icon icon = btnImg4.getIcon();
        String path = "";
//        if (icon instanceof ImageIcon) {
//            path = ((ImageIcon) icon).getDescription();
//        }
        path = (String) btnImg4.getClientProperty("img_path");
        setScaleImage(jLabel6, path, true);
    }//GEN-LAST:event_btnImg4ActionPerformed

    private void btnImg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImg1ActionPerformed
        // TODO add your handling code here:
        Icon icon = btnImg1.getIcon();
        String path = "";
//        if (icon instanceof ImageIcon) {
//            path = ((ImageIcon) icon).getDescription();
//        }
        path = (String) btnImg1.getClientProperty("img_path");
        setScaleImage(jLabel6, path, true);
    }//GEN-LAST:event_btnImg1ActionPerformed

    private void btnImg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImg2ActionPerformed
        // TODO add your handling code here:
        Icon icon = btnImg2.getIcon();
        String path = "";
//        if (icon instanceof ImageIcon) {
//            path = ((ImageIcon) icon).getDescription();
//        }
        path = (String) btnImg2.getClientProperty("img_path");
        setScaleImage(jLabel6, path, true);
    }//GEN-LAST:event_btnImg2ActionPerformed

    private void btnImg1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImg1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImg1MouseEntered

    private void btnImgGame2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgGame2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImgGame2ActionPerformed

    private void btnImgGame4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgGame4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImgGame4ActionPerformed

    private void btnNextImgGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextImgGameActionPerformed
        // TODO add your handling code here:
        if (selectedButton == null){// kiem tra null truoc
            //neu co mac dinh gan cho btnImgGame1
            Icon icon = btnImgGame1.getIcon();
            String path = "";
            if (icon instanceof ImageIcon) {
                path = ((ImageIcon) icon).getDescription();
            }
            //path = (String) btnImgGame1.getClientProperty("img_path");
            //System.out.println(path);
            setScaleImage(imgGameMain, path, false);
            btnImgGame1.setBorderPainted(true);
            btnImgGame1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButton = btnImgGame1;
            
            
        }
        else{
            // xoa border cho btn dang chon va lay path
            Icon icon = selectedButton.getIcon();
            String path = "";
            if (icon instanceof ImageIcon) {
                path = ((ImageIcon) icon).getDescription();
            }
            //path = (String) selectedButton.getClientProperty("img_path");
            String spec = path.split("/")[2];
            
            selectedButton.setBorderPainted(false);
            selectedButton.setBorder(null);
            
            // bat dau lay btn tieo theo, path cua no va gan cho selectedButton
            JButton new_but = new JButton();
            switch (spec.charAt(0)){
                        case '2':
                            new_but = btnImgGame2;
                            break;
                        case '3':
                            new_but = btnImgGame3;
                            break;
                        case '4':
                            new_but = btnImgGame4;
                            break;
                        case '5':
                            new_but = btnImgGame1;
                            break;
            }
            Icon new_icon = new_but.getIcon();
            String new_path = "";
            if (icon instanceof ImageIcon) {
                    new_path = ((ImageIcon) new_icon).getDescription();
            }
            //path = (String) new_but.getClientProperty("img_path");
            setScaleImage(imgGameMain, new_path, false);
            new_but.setBorderPainted(true);
            new_but.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButton = new_but;
            
        }
    }//GEN-LAST:event_btnNextImgGameActionPerformed

    private void btnPreviousImgGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousImgGameActionPerformed
        // TODO add your handling code here:
        if (selectedButton == null){// kiem tra null truoc
            //neu co mac dinh gan cho btnImgGame1
            Icon icon = btnImgGame1.getIcon();
            String path = "";
            if (icon instanceof ImageIcon) {
                path = ((ImageIcon) icon).getDescription();
            }
            //System.out.println(path);
            //path = (String) btnImgGame1.getClientProperty("img_path");
            setScaleImage(imgGameMain, path, false);
            btnImgGame1.setBorderPainted(true);
            btnImgGame1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButton = btnImgGame1;

        }
        else{
            // xoa border cho btn dang chon va lay path
            Icon icon = selectedButton.getIcon();
            String path = "";
            if (icon instanceof ImageIcon) {
                path = ((ImageIcon) icon).getDescription();
            }
            //path = (String) selectedButton.getClientProperty("img_path");
            String spec = path.split("/")[2];
            
            selectedButton.setBorderPainted(false);
            selectedButton.setBorder(null);
            
            // bat dau lay btn truoc do, path cua no va gan cho selectedButton
            JButton new_but = new JButton();
            switch (spec.charAt(0)){
                        case '2':
                            new_but = btnImgGame4;
                            break;
                        case '3':
                            new_but = btnImgGame1;
                            break;
                        case '4':
                            new_but = btnImgGame2;
                            break;
                        case '5':
                            new_but = btnImgGame3;
                            break;
            }
            Icon new_icon = new_but.getIcon();
            String new_path = "";
            if (icon instanceof ImageIcon) {
                    new_path = ((ImageIcon) new_icon).getDescription();
            }
            //new_path = (String) new_but.getClientProperty("img_path");
            setScaleImage(imgGameMain, new_path, false);
            new_but.setBorderPainted(true);
            new_but.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButton = new_but;
            
        }
    }//GEN-LAST:event_btnPreviousImgGameActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void butBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuyActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_butBuyActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        c1.show(mainContainer, "cardLibrary");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void butChangeToReviewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butChangeToReviewPostActionPerformed
        // TODO add your handling code here:
        c1.show(mainContainer, "card8");
    }//GEN-LAST:event_butChangeToReviewPostActionPerformed

    private void btnAddBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBalanceActionPerformed
        // TODO add your handling code here:
        String strCredits = JOptionPane.showInputDialog(this, "Nhập số tiền muốn nạp:", "Add social credits", JOptionPane.QUESTION_MESSAGE);
        try{
            double credits = Double.parseDouble(strCredits);
            if (credits < 0){
                JOptionPane.showMessageDialog(this, "Không nhập số âm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (!userRepository.updateWalletBalance(userInfo.getUserId(), userInfo.getWalletBalance() + credits)){
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            userInfo.setWalletBalance(userInfo.getWalletBalance() + credits);
            updateCreditsInUI();
            JOptionPane.showMessageDialog(this, "Bạn đã thêm thành công " + strCredits + " vào tài khoản.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Nhập không đúng định dạng", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnAddBalanceActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void butNextGameInStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextGameInStoreActionPerformed
        // TODO add your handling code here:
        if (selectedButtonGameInStore == null){// kiem tra null truoc
            //neu co mac dinh gan cho btnImgGame1
            JButton defaultButton = (JButton) panelChangeGame.getComponent(0);
            //setScaleImage(imgGameMain, path);
            defaultButton.setBorderPainted(true);
            defaultButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButtonGameInStore  = defaultButton;
            selectedButtonGameInStoreIndex = 0;
            selectedButtonGameInStore.doClick();
        }
        else{
            selectedButtonGameInStore.setBorderPainted(false);
            selectedButtonGameInStore.setBorder(null);
            // bat dau lay btn tieo theo, path cua no va gan cho selectedButton
            JButton new_but = new JButton();
            if (selectedButtonGameInStoreIndex == 7){
                new_but = (JButton) panelChangeGame.getComponent(0);
                selectedButtonGameInStoreIndex = 0;
            }
            else{
                new_but = (JButton) panelChangeGame.getComponent(selectedButtonGameInStoreIndex + 1);
                selectedButtonGameInStoreIndex += 1;
            }
            new_but.setBorderPainted(true);
            new_but.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButtonGameInStore = new_but;
            selectedButtonGameInStore.doClick();
            
        } 
    }//GEN-LAST:event_butNextGameInStoreActionPerformed

    private void butPreviousGameInStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPreviousGameInStoreActionPerformed
        // TODO add your handling code here:
        if (selectedButtonGameInStore == null){// kiem tra null truoc
            //neu co mac dinh gan cho btnImgGame1
            JButton defaultButton = (JButton) panelChangeGame.getComponent(0);
            //setScaleImage(imgGameMain, path);
            defaultButton.setBorderPainted(true);
            defaultButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButtonGameInStore  = defaultButton;
            selectedButtonGameInStoreIndex = 0;
            selectedButtonGameInStore.doClick();
        }
        else{
            selectedButtonGameInStore.setBorderPainted(false);
            selectedButtonGameInStore.setBorder(null);
            // bat dau lay btn tieo theo, path cua no va gan cho selectedButton
            JButton new_but = new JButton();
            if (selectedButtonGameInStoreIndex == 0){
                new_but = (JButton) panelChangeGame.getComponent(7);
                selectedButtonGameInStoreIndex = 7;
            }
            else{
                new_but = (JButton) panelChangeGame.getComponent(selectedButtonGameInStoreIndex - 1);
                selectedButtonGameInStoreIndex -= 1;
            }
            new_but.setBorderPainted(true);
            new_but.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, false));
            selectedButtonGameInStore = new_but;
            selectedButtonGameInStore.doClick();
            
        } 
            
    }//GEN-LAST:event_butPreviousGameInStoreActionPerformed

    private void btnPreviousContainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousContainerActionPerformed
        // TODO add your handling code here:
        if(currentNode.getPrev() == null){
            return;
        }
        Node temp = currentNode.getPrev();
        Object data = temp.getData();
        if (data instanceof Game){
            
            initGameMenu((Game)data, false);
            c1.show(mainContainer, "cardGame");
            addDeveloperInteractable((Game)data);
            SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                        addPurchaseStatusToGame((Game)data);
                        addDeveloperInteractable((Game)data);
                        addReviewsInGameMenu((Game)data);
                });
        }
        else if (data instanceof Category){
            
            initGameInGenre((Category)data, false);
            c1.show(mainContainer, "cardGenre");
        }
        else if (data instanceof Developer){
            
            initGameInDev((Developer)data, false);
            c1.show(mainContainer, "cardDeveloper");
        }
        else if (data instanceof libraryDLL){
            if(selectedButInJTool != btnLibrary){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnLibrary;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
            }
            c1.show(mainContainer, "cardLibrary");
        }
        else if (data instanceof storeDLL){
            if(selectedButInJTool != btnStore){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnStore;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
            }
            c1.show(mainContainer, "cardStore");
            
        }
        currentNode = temp;
    }//GEN-LAST:event_btnPreviousContainerActionPerformed

    private void btnNextContainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextContainerActionPerformed
        // TODO add your handling code here:
        if(currentNode.getNext() == null){
            return;
        }
        
        Node temp = currentNode.getNext();
        Object data = temp.getData();
        if (data instanceof Game){
            initGameMenu((Game)data, false);
            
            c1.show(mainContainer, "cardGame");
            addDeveloperInteractable((Game)data);
            SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                        addPurchaseStatusToGame((Game)data);
                        addDeveloperInteractable((Game)data);
                        addReviewsInGameMenu((Game)data);
                });
        }
        else if (data instanceof Category){
            
            initGameInGenre((Category)data, false);
            c1.show(mainContainer, "cardGenre");
        }
        else if (data instanceof Developer){
            
            initGameInDev((Developer)data, false);
            c1.show(mainContainer, "cardDeveloper");
        }
        else if (data instanceof libraryDLL){
            if(selectedButInJTool != btnLibrary){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnLibrary;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
            }
            c1.show(mainContainer, "cardLibrary");
        }
        else if (data instanceof storeDLL){
            if(selectedButInJTool != btnStore){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnStore;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
            }
            c1.show(mainContainer, "cardStore");
        }
        currentNode = temp;
    }//GEN-LAST:event_btnNextContainerActionPerformed

    private void btnshowInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowInformationActionPerformed
        // TODO add your handling code here:
        UserProfile dialog = new UserProfile(this, true, userInfo, numberGamesUserPurchased);
        dialog.setMainFrame(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnshowInformationActionPerformed

    private void txtDeveloperInGameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeveloperInGameMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeveloperInGameMenuActionPerformed

    private void btnImgGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgGame1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImgGame1ActionPerformed

    private void updateCreditsInUI(){
        //.setText("Số dư: " + Double.toString(userRepository.findById(userInfo.getUserId()).getWalletBalance()) + " VND");
        lblBalance.setText("Balance: " + Double.toString(userInfo.getWalletBalance()) + " VND");

    }
    private void initTransaction(Game game){
        //panelTransaction.removeAll();
        //panelTransaction.revalidate();
        //panelTransaction.repaint();
        btnConfirmCheck.setSelected(false);
        btnPurchase.setEnabled(true);
        if (btnPurchase.getActionListeners().length != 0){
            //System.out.println(btnPurchase.getActionListeners().length);
            btnPurchase.removeActionListener(btnPurchase.getActionListeners()[0]);
        }
        jLabel18.setVisible(false);
        setScaleImage(jLabel4, "/game" +game.getId() + "/header.jpg", false);
        lblGameNameInTransaction.setText(game.getName());
        lblPriceInTransaction.setText(Double.toString(game.getPrice()));
        lblTagInTransaction.setText(lblGameTag.getText());
        lblReleaseDateInTransaction.setText(sdf.format(game.getReleaseDate()));
        lblCashBeforePurchase.setText(Double.toString(userInfo.getWalletBalance()));
        lblCashNeedToPurchase.setText(Double.toString(game.getPrice()));
        lblCashAfterPurchase.setText(Double.toString(userInfo.getWalletBalance() - game.getPrice()));
        if(userInfo.getWalletBalance() - game.getPrice() < 0){
            jLabel18.setText("Số dư không đủ vui lòng nạp thêm");
            jLabel18.setVisible(true);
            btnPurchase.setEnabled(false);
        }
        btnPurchase.addActionListener(e -> {
                if(userInfo.getWalletBalance() - game.getPrice() < 0){
                    jLabel18.setText("Số dư không đủ vui lòng nạp thêm");
                    return;
                }
                if (!btnConfirmCheck.isSelected()){
                    jLabel18.setText("Click vào ô 'Đồng ý với chính sách' để tiếp tục");
                    jLabel18.setVisible(true);
                    return;
                }
                boolean isSuccess = transactionService.buyGameWithRollBack(userInfo, game);
                if(!isSuccess){
                    JOptionPane.showMessageDialog(mainContainer, "Thanh toán không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                jLabel18.setVisible(false);
                JOptionPane.showMessageDialog(mainContainer, "Thanh toán thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                addGameIntoLibrary(game);
                updatePanel36Size();
                jPanel36.revalidate();
                jPanel36.repaint();
                userInfo.setWalletBalance(userInfo.getWalletBalance() - game.getPrice());
                updateCreditsInUI();
                initGameMenu(game, false);
                c1.show(mainContainer,"cardGame");
                SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                        addPurchaseStatusToGame(game);
                        addDeveloperInteractable(game);
                        addReviewsInGameMenu(game);
                });
                butBuy.setText("In library");
            
        });
    }
    
    private void resetUITransaction(){
        
    
    }
    
    ////
    private void addPlaceholder(JTextField field, String placeholder) {
    field.setText(placeholder);
    field.setForeground(Color.GRAY);

    field.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (field.getText().equals(placeholder)) {
                field.setText("");
                field.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (field.getText().isEmpty()) {
                field.setText(placeholder);
                field.setForeground(Color.GRAY);
            }
        }
    });
}
    
    
    ///
    private void setScaleImage(JLabel objectName, String path, boolean inStore){
        int width = objectName.getWidth();
        int height = objectName.getHeight();

        if (width == 0){
            width = 50;
        }
        if (height == 0){
            height= 50;
        }
        if (!inStore){
            Icon oldIcon = objectName.getIcon();
            if (oldIcon instanceof ImageIcon) {
                Image oldImg = ((ImageIcon) oldIcon).getImage();
                if (oldImg != null) {
                    oldImg.flush(); // Giải phóng bộ nhớ của ảnh cũ
                }
            }
            objectName.setIcon(null);
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            scaledIcon.setDescription(path); // 🔹 Lưu lại đường dẫn
            objectName.setIcon(scaledIcon);
        }
        else{
            // Co ảnh lại cho vừa khung
            ImageIcon img = ImageCache.getScaledImage(path, width, height);


            objectName.setIcon(img);
            objectName.putClientProperty("img_path", path);
        }
    
    }
    
    private void setScaleImageBut(JButton objectName, String path, boolean inStore){
        int width = objectName.getWidth();
        int height = objectName.getHeight();

        if (width == 0){
            width = 50;
        }
        if (height == 0){
            height= 50;
        }
        if (!inStore){
            Icon oldIcon = objectName.getIcon();
            if (oldIcon instanceof ImageIcon) {
                Image oldImg = ((ImageIcon) oldIcon).getImage();
                if (oldImg != null) {
                    oldImg.flush(); // Giải phóng bộ nhớ của ảnh cũ
                }
            }
            objectName.setIcon(null);
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            scaledIcon.setDescription(path); // 🔹 Lưu lại đường dẫn
            objectName.setIcon(scaledIcon);
        }
        else{
            Object oldPath = objectName.getClientProperty("img_path");
            if (oldPath != null) {
                objectName.putClientProperty("img_path", null); // xóa key
            }
            // Co ảnh lại cho vừa khung
            ImageIcon img = ImageCache.getScaledImage(path, width, height);
            objectName.setIcon(img);
            objectName.putClientProperty("img_path", path);
        }
    }
    
    //
    
    
    private void initHoverListener() {
        //System.out.println(jPanel23.getAccessibleContext().getAccessibleName());
        //System.out.println(jPanel24.getAccessibleContext().getAccessibleName());
        addHoverEffect(jPanel23, "game1");
        addHoverEffect(jPanel24, "game2");
        addHoverEffect(jPanel25, "game3");
        addHoverEffect(jPanel26, "game4");
        addHoverEffect(jPanel28, "game5");
        
    }
    
    private void addHoverEffect(JComponent comp, String gameID) {
        
        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                resetHoverForPanelGameInStore((JPanel) comp);
                //comp.setBorder(new RoundedBorder(15, java.awt.Color.GRAY, 2));
                //new RoundedBorder(15, java.awt.Color.GRAY, 2)
                //GameInfo game = items.get(Character.getNumericValue(gameID.charAt(gameID.length() - 1)) - 1);
                lblGameNameWhenHover.setText(comp.getAccessibleContext().getAccessibleDescription());
                lblGameTag.setText("Tag: "+comp.getAccessibleContext().getAccessibleName());
                setScaleImage(jLabel12, "/" + gameID +"/2.jpg", true);
                setScaleImage(jLabel13, "/" + gameID +"/3.jpg", true);
                setScaleImage(jLabel14, "/" + gameID +"/4.jpg", true);
                setScaleImage(jLabel15, "/" + gameID +"/5.jpg", true);
                lblReviewInStore.setText(ratingFirGameInStore.get(Character.getNumericValue(gameID.charAt(gameID.length() - 1)) - 1));
//                comp.getComponent(1).setForeground(Color.black);
//                comp.getComponent(2).setForeground(Color.black);
//                comp.getComponent(3).setForeground(Color.black);
//                comp.getComponent(4).setForeground(Color.black);
            }
            
            @Override
            public void mousePressed(MouseEvent e){
                setScaleImage(imgGame, "/" + gameID +"/header.jpg", false);
                Game gameDetail = gameQuerry8.get(Integer.parseInt(gameID.substring(gameID.length() - 1)) - 1);
                //Game gameDetail = gameRepository.findById(Integer.parseInt(gameID.substring(gameID.length() - 1)));
                initGameMenu(gameDetail, true);
                
                c1.show(mainContainer, "cardGame");
                SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                        addPurchaseStatusToGame(gameDetail);
                        addDeveloperInteractable(gameDetail);
                        addReviewsInGameMenu(gameDetail);
                });
            }

            @Override
            public void mouseExited(MouseEvent e) {
                comp.setBorder(null);
            }
            

            
        });
    }
    
    
    private void resetHoverForPanelGameInStore(JPanel comp){
        if (hoveredPanelGameInStore != null){
            hoveredPanelGameInStore.getComponent(1).setForeground(Color.WHITE);
            hoveredPanelGameInStore.getComponent(2).setForeground(Color.WHITE);
            hoveredPanelGameInStore.getComponent(3).setForeground(Color.WHITE);
            hoveredPanelGameInStore.getComponent(4).setForeground(Color.WHITE);
            hoveredPanelGameInStore.setBackground(Color.decode("#1C2E3E"));
        }
        
        comp.getComponent(1).setForeground(Color.BLACK);
        comp.getComponent(2).setForeground(Color.BLACK);
        comp.getComponent(3).setForeground(Color.BLACK);
        comp.getComponent(4).setForeground(Color.BLACK);
        comp.setBackground(Color.decode("#95BBD4"));
        hoveredPanelGameInStore = comp;
    }
    
    
    
    private JPanel createPanelGameInLibrary(String titleText, String imagePath) {
        // Panel chính
        JPanel panelGameInLibrary = new JPanel(new BorderLayout());
        panelGameInLibrary.setSize(300, 44);
        panelGameInLibrary.setMaximumSize(new Dimension(300, 44));
        panelGameInLibrary.setMinimumSize(new Dimension(300, 44));
        panelGameInLibrary.setBackground(new Color(240, 240, 240)); // màu nền nhạt (giống NetBeans)
        panelGameInLibrary.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // ===== ẢNH (jPanel3 + imgGameInLibrary) =====
        JPanel jPanel3 = new JPanel(new GridLayout(1, 1));
        jPanel3.setPreferredSize(new Dimension(65, 50));
        jPanel3.setOpaque(false);

        JLabel imgGameInLibrary = new JLabel();
        imgGameInLibrary.setHorizontalAlignment(SwingConstants.LEFT);
        //imgGameInLibrary.setPreferredSize(new Dimension(150, 250));

        // Gán ảnh (scale vừa khung)
        setScaleImage(imgGameInLibrary, imagePath, false);
        jPanel3.add(imgGameInLibrary);

        // ===== TÊN GAME (jPanel35 + jLabel1) =====
        JPanel jPanel35 = new JPanel(new GridLayout(1, 1));
        jPanel35.setOpaque(false);

        JLabel jLabel1 = new JLabel(titleText);
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        jPanel35.add(jLabel1);

        // Thêm vào BorderLayout
        panelGameInLibrary.add(jPanel3, BorderLayout.WEST);
        panelGameInLibrary.add(jPanel35, BorderLayout.CENTER);

        return panelGameInLibrary;
}

    
    private void initGameInLibrary(User user) {
    // "panelGameInLibrary" nằm ở Other Components
        //jPanel36.removeAll();
        
        jPanel36.setLayout(new BoxLayout(jPanel36, BoxLayout.Y_AXIS));
        jPanel36.removeAll();
        java.util.List<Game> gamesOwn = containRepository.gamesOwnByUser(user.getUserId());
        for(Game s:gamesOwn){
            //numberGamesUserPurchased += 1;
            //System.out.println(s.getGameName());
            addGameIntoLibrary(s);
            
        }
        SwingUtilities.invokeLater(() -> {
        updatePanel36Size();
        });
        // ham duoi dung de test
        //printChildComponents(jPanel36);
    }
    private void printChildComponents(JPanel parentPanel) {
    System.out.println("===== Components in " + parentPanel.getName() + " =====");
    System.out.println("Total components: " + parentPanel.getComponentCount());
    
    Component[] components = parentPanel.getComponents();
    
    for (int i = 0; i < components.length; i++) {
        Component comp = components[i];
        System.out.println(i + ". " + comp.getClass().getSimpleName() + 
                          " - " + comp.getName() + 
                          " - Size: " + comp.getAccessibleContext().getAccessibleDescription());
    }
    System.out.println("=====================================");
}





    private void addGameIntoLibrary(Game s){
        
        JPanel addGame = initInfoForEachGameInLibrary(s.getName(), "/game"+s.getId()+"/header.jpg");
        Dimension prefSize = addGame.getPreferredSize();
        //addGame.setAlignmentX(Component.LEFT_ALIGNMENT);
        // 2. Đặt kích thước TỐI ĐA (maximum size)
        // Cho phép nó dãn chiều ngang (MAX_VALUE) nhưng KHÓA chiều cao (prefSize.height)
        addGame.setMaximumSize(new Dimension(Integer.MAX_VALUE, prefSize.height));
        addGame.getAccessibleContext().setAccessibleDescription(Integer.toString(s.getGameId()));
        jPanel36.add(addGame);
        
        addClickGameInLibrary(addGame, s);
        //addGameContextMenu(addGame, s);
        jPanel36.add(Box.createVerticalStrut(7));
        numberGamesUserPurchased += 1;
        
    }
    
    private void updatePanel36Size() {
    // Cho Swing tự đo trước
    jPanel36.setPreferredSize(null);
    Dimension preferred = jPanel36.getPreferredSize();

    int width = 300;

    //  Giới hạn chiều cao tối thiểu = chiều cao viewport
    int viewportHeight = jScrollPane2.getViewport().getHeight();
    int finalHeight = Math.max(preferred.height, viewportHeight);

    jPanel36.setPreferredSize(new Dimension(width, finalHeight));
    jPanel36.revalidate();
    jPanel36.repaint();
}
    
    private JPanel initInfoForEachGameInLibrary(String name, String path){
        return new Test3(name, path);
        
    }
    
    private void addClickGameInLibrary(JPanel comp, Game game){
        
        JPopupMenu popupMenu = new JPopupMenu();

        // Menu items
        JMenuItem play = new JMenuItem("▶ Play");
        JMenuItem viewDetails = new JMenuItem("🔍 View Details");
        JMenuItem properties = new JMenuItem("⚙ Properties");
        JMenuItem uninstall = new JMenuItem("🗑 Uninstall");
        JMenuItem removeGameFromLibrary = new JMenuItem("🗑 Remove from library");

        // Actions
        play.addActionListener(e -> System.out.println("Clicked Play button"));
        viewDetails.addActionListener(e -> System.out.println("Clicked viewDetails button"));
        properties.addActionListener(e -> System.out.println("Clicked properties button"));
        uninstall.addActionListener(e -> System.out.println("Clicked uninstall button " + game.getGameName()));
        removeGameFromLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                mainContainer,
                "Are you sure you want to remove " + game.getGameName() + " from your library?",
                "Confirm Removal",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

                if (result == JOptionPane.YES_OPTION) {
                    deletePanelFromPanelLibrary(game);
                    jPanel34.setVisible(false);
                    imgGameInfo.setVisible(false);
                    JOptionPane.showMessageDialog(mainContainer, "Da xoa thanh cong", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
                    deleteGameFromPanelLibrarySQL(game);
                }
                

                
            }
        });
        // Build menu
        popupMenu.add(play);
        popupMenu.addSeparator();
        popupMenu.add(viewDetails);
        popupMenu.add(properties);
        popupMenu.addSeparator();
        popupMenu.add(uninstall);
        popupMenu.add(removeGameFromLibrary);
        
        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
                if(butChangeToReviewPost.getActionListeners().length != 0){
                    butChangeToReviewPost.removeActionListener(butChangeToReviewPost.getActionListeners()[0]);
                }
                butChangeToReviewPost.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        initReviewPostGame(game);
                        c1.show(mainContainer, "card8");
                    }
                });
                if (selectedPanelGameInLibrary != null && selectedPanelGameInLibrary != comp) {
                    // Bỏ chọn cái cũ
                    selectedPanelGameInLibrary.setBorder(null);
                                // cho phép trong suốt                    
                }

                if (selectedPanelGameInLibrary == comp) {
                    // Click lại chính nó => bỏ chọn
                    //comp.setBackground(Color.LIGHT_GRAY);
                    selectedPanelGameInLibrary = null;
                } else {
                    // Chọn cái mới
                    comp.setBorder(new RoundedBorder(5, Color.WHITE, 2));
                    imgGameInfo.setVisible(true);
                    jPanel34.setVisible(true);
                    setScaleImage(imgGameInfo, "/game" + game.getId() +"/header.jpg", false);
                    selectedPanelGameInLibrary = comp;
                }
                for (ActionListener al : butDetailGame.getActionListeners())
                    butDetailGame.removeActionListener(al);

                butDetailGame.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        initGameMenu(game, true);
                        c1.show(mainContainer, "cardGame");
                        SwingUtilities.invokeLater(() -> {
                                    // Gọi hàm load data
                                addPurchaseStatusToGame(game);
                                addDeveloperInteractable(game);
                                addReviewsInGameMenu(game);
                        });
                    }

                });
            }
        });
        
        
        
    }
    
    private void deletePanelFromPanelLibrary(Game game){
        Component[] components = jPanel36.getComponents();

        for (int i = 0; i < components.length; i = i + 2) {
            Component comp = components[i];
            if(comp.getAccessibleContext().getAccessibleDescription().equals(Integer.toString(game.getGameId()))){
                jPanel36.remove(comp);
                jPanel36.remove(components[i + 1]);
                updatePanel36Size();
                return;
            }
        }
    }
    
    private void deleteGameFromPanelLibrarySQL(Game game){
        //boolean removeStatus = containRepository.removeGameFromUser(userInfo.getUserId(), game.getGameId());
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>(){
            @Override
            protected Boolean doInBackground() throws Exception {
                return containRepository.removeGameFromUser(userInfo.getUserId(), game.getGameId());
            }
            @Override
            protected void done() {
                try {
                    numberGamesUserPurchased -= 1;
                    boolean removeStatus = get();
                    if (!removeStatus){
                        JOptionPane.showMessageDialog(mainContainer, "Đã xảy ra lỗi", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        addGameIntoLibrary(game);
                    
                    return;
        }
                    
                }
                catch (InterruptedException e) {
                    
                    System.out.println("Remove operation cancelled");
                    e.printStackTrace();
                
                } catch (ExecutionException e) {
                    // Error occurred
                    JOptionPane.showMessageDialog(
                        mainContainer,
                        "Failed to remove game: " + e.getCause().getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    e.printStackTrace();
            }
            }
        };
        
        worker.execute();
    }
     
    
    private void initReviewPostGame(Game game){
        butDeleteReview.setVisible(false);
        butDeleteReview.setEnabled(false);
        buttonGroup1.clearSelection();
        txtReview.setText("");
        if (butPostReview.getActionListeners().length != 0){
            butPostReview.removeActionListener(butPostReview.getActionListeners()[0]);
        }
        if (butDeleteReview.getActionListeners().length != 0){
            butDeleteReview.removeActionListener(butDeleteReview.getActionListeners()[0]);
        }
//        if (buttonGroup1.getSelection() != null){
//            buttonGroup1.clearSelection();
//        }
        Review reviewAlreadyPost = reviewRepository.findByGameIdAndUserId(game.getGameId(), userInfo.getUserId());
        lblGameNameInReviewPost.setText(game.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lblGameReleaseDateInReviewPost.setText(sdf.format(game.getReleaseDate()));
        setScaleImage(lblImgGameInReviewPost, "/game" + game.getId() + "/header.jpg", false);
        if (reviewAlreadyPost != null){
            txtReview.setText(reviewAlreadyPost.getComment());
            butDeleteReview.setVisible(true);
            butDeleteReview.setEnabled(true);
            if (reviewAlreadyPost.getRating().equals("0")){
                butNo.setSelected(true);
            }
            else{
                butYes.setSelected(true);
            }
        }
        
        
        butPostReview.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code xử lý khi nhấn nút
                String recommend;
                if (buttonGroup1.getSelection() == null) {
                    JOptionPane.showMessageDialog(mainContainer, "Vui lòng cho biết bạn thích hoặc không thích tựa game.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (txtReview.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(mainContainer, "Vui lòng điền phần comment.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (buttonGroup1.getSelection().getActionCommand().equals("Yes")){
                    recommend = "1";
                }
                else{
                    recommend = "0";
                }
                Review insertReview = reviewRepository.save(new Review(game.getGameId(), userInfo.getUserId(),
                                                            txtReview.getText().trim(), recommend));
                if (insertReview == null){
                    JOptionPane.showMessageDialog(mainContainer, "Đã xảy ra lỗi", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(mainContainer, "Đã thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    c1.show(mainContainer, "cardLibrary");
                }
                //System.out.println("Button clicked!");
                
            }
        });
        
        butDeleteReview.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                mainContainer,
                "Bạn có chắc muốn xóa review này không",
                "Xác nhận xóa review",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

                if (result == JOptionPane.YES_OPTION) {
                    boolean deleteStatus = reviewRepository.deleteByGameIdAndUserId(game.getGameId(), userInfo.getUserId());
                    if (!deleteStatus){
                        JOptionPane.showMessageDialog(mainContainer, "Đã xảy ra lỗi", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(mainContainer, "Đã xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                  butDeleteReview.setVisible(false);
//                  butDeleteReview.setEnabled(false);
                    c1.show(mainContainer, "cardLibrary");
                }
            }
        });
        
    }
    
    private void initGameInGenre(Category genre, boolean updateNode){
        if(selectedButInJTool != btnStore){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnStore;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
            }
        if (updateNode){
        dll.cutAfter(currentNode);
        dll.addLast(genre);
        currentNode = dll.getTail();
        }
        jPanel67.removeAll();
        java.util.List<Game> gameFindViaGenre = gameRepository.findByCategory(genre.getName());
        for (MouseWheelListener mwl : jPanel67.getMouseWheelListeners()) {
            jPanel67.removeMouseWheelListener(mwl);
        }

        // Thêm listener mới
        jPanel67.addMouseWheelListener(e -> {
            JScrollBar scrollBar = scrollPaneGamesGenre.getVerticalScrollBar();
            int scrollAmount = e.getUnitsToScroll() * scrollBar.getUnitIncrement();
            scrollBar.setValue(scrollBar.getValue() + scrollAmount);
        });
        
        for(Game s: gameFindViaGenre){
            JPanel addGameGenre = new GameInGenre(s);
            Dimension prefSize = addGameGenre.getPreferredSize();
            addGameGenre.setMaximumSize(new Dimension(Integer.MAX_VALUE, prefSize.height));
            addClickForGameInGenre(addGameGenre, s);
            jPanel67.add(addGameGenre);
            jPanel67.add(Box.createVerticalStrut(7)); 
            
        }
        jPanel67.revalidate();
        jPanel67.repaint();
      
    }
    
    private void addClickForGameInGenre(JPanel panel, Game game){
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                initGameMenu(game, true);
                c1.show(mainContainer, "cardGame");
                SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                        addPurchaseStatusToGame(game);
                        addDeveloperInteractable(game);
                        addReviewsInGameMenu(game);
                });
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            
        });
        panel.addMouseWheelListener(e -> {
            JScrollBar scrollBar = scrollPaneGamesGenre.getVerticalScrollBar();
            int scrollAmount = e.getUnitsToScroll() * scrollBar.getUnitIncrement();
            scrollBar.setValue(scrollBar.getValue() + scrollAmount);
        });
    }
    
    private void initGameInDev(Developer dev, boolean updateNode){
        if(selectedButInJTool != btnStore){
                selectedButInJTool.setForeground(Color.WHITE);
                selectedButInJTool = btnStore;
                selectedButInJTool.setForeground(Color.decode("#00A3FF"));
            }
        if (updateNode){
            dll.cutAfter(currentNode);
            dll.addLast(dev);
            currentNode = dll.getTail();
        }
        lblDevName.setText(dev.getName());
        if (dev.getDevId() == 3 || dev.getDevId() == 9 ||dev.getDevId() == 18 ||dev.getDevId() == 19 || dev.getDevId() == 23){
            setScaleImage(lblImgDev, "/devImg/devNoImg.jpg", false);
        }
        else{
            setScaleImage(lblImgDev, "/devImg/dev"+ Integer.toString(dev.getDevId())+".jpg", false);
        }
        panelListGameDev.removeAll();
        java.util.List<Game> gameFindViaDeveloper = gameRepository.findByDeveloper(dev.getDevId());

        for (MouseWheelListener mwl : panelListGameDev.getMouseWheelListeners()) {
            panelListGameDev.removeMouseWheelListener(mwl);
        }
        
        
        // Thêm listener mới
//        panelListGameDev.addMouseWheelListener(e -> {
//            JScrollBar scrollBar = scrollPanelDevs.getVerticalScrollBar();
//            int scrollAmount = e.getUnitsToScroll() * scrollBar.getUnitIncrement();
//            scrollBar.setValue(scrollBar.getValue() + scrollAmount);
//        });
        
        for(Game s: gameFindViaDeveloper){
            JPanel addGameGenre = new GameInGenre(s);
            Dimension prefSize = addGameGenre.getPreferredSize();
            addGameGenre.setMaximumSize(new Dimension(Integer.MAX_VALUE, prefSize.height));
            addClickEffectForGameInDev(addGameGenre, s);
            panelListGameDev.add(addGameGenre);
            panelListGameDev.add(Box.createVerticalStrut(7)); 
            
        }
        panelListGameDev.revalidate();
    
        // Lấy chiều cao của jPanel41 (thông tin dev)
        int panel41Height = jPanel41.getPreferredSize().height;

        // Tính tổng chiều cao của panelListGameDev
        int gameListHeight = 0;
        for (Component comp : panelListGameDev.getComponents()) {
            gameListHeight += comp.getPreferredSize().height;
        }

        // Tổng chiều cao = panel41 + danh sách game
        int totalHeight = panel41Height + gameListHeight;

        // ✅ UPDATE PREFERRED SIZE CHO jPanel40
        jPanel40.setPreferredSize(new Dimension(
            jPanel40.getPreferredSize().width, 
            totalHeight
        ));

        // Revalidate toàn bộ
        jPanel40.revalidate();
        jPanel40.repaint();
        scrollPanelDevs.revalidate();
        scrollPanelDevs.repaint();
//        scrollPanelDevs.revalidate();
//        scrollPanelDevs.repaint(); 
    }
    
    private void addClickEffectForGameInDev(JPanel panel, Game game){
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                initGameMenu(game, true);
                c1.show(mainContainer, "cardGame");
                SwingUtilities.invokeLater(() -> {
                            // Gọi hàm load data
                        addPurchaseStatusToGame(game);
                        addDeveloperInteractable(game);
                        addReviewsInGameMenu(game);
                });
            }   

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            
        });
        panel.addMouseWheelListener(e -> {
            JScrollBar scrollBar = scrollPanelDevs.getVerticalScrollBar();
            int scrollAmount = e.getUnitsToScroll() * scrollBar.getUnitIncrement();
            scrollBar.setValue(scrollBar.getValue() + scrollAmount);
        });
    }
    
    public void updateUserInfoAfterChange(User newUser){
        userInfo = newUser;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(User userInfo) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainMenu(userInfo).setVisible(true));
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Steam;
    private javax.swing.JMenuItem btnAddBalance;
    private javax.swing.JCheckBox btnConfirmCheck;
    private javax.swing.JButton btnImg1;
    private javax.swing.JButton btnImg2;
    private javax.swing.JButton btnImg3;
    private javax.swing.JButton btnImg4;
    private javax.swing.JButton btnImgGame1;
    private javax.swing.JButton btnImgGame2;
    private javax.swing.JButton btnImgGame3;
    private javax.swing.JButton btnImgGame4;
    private javax.swing.JButton btnLibrary;
    private javax.swing.JButton btnNextContainer;
    private javax.swing.JButton btnNextImgGame;
    private javax.swing.JButton btnPreviousContainer;
    private javax.swing.JButton btnPreviousImgGame;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JMenuItem btnSignOut;
    private javax.swing.JButton btnStore;
    private javax.swing.JMenuItem btnshowInformation;
    private javax.swing.JButton butBuy;
    private javax.swing.JButton butChangeToReviewPost;
    private javax.swing.JButton butDeleteReview;
    private javax.swing.JButton butDetailGame;
    private javax.swing.JButton butNextGameInStore;
    private javax.swing.JRadioButton butNo;
    private javax.swing.JButton butPostReview;
    private javax.swing.JButton butPreviousGameInStore;
    private javax.swing.JRadioButton butYes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<GeneralInfo> comboBox;
    private javax.swing.JLabel imgGame;
    private javax.swing.JLabel imgGameInfo;
    private javax.swing.JPanel imgGameList;
    private javax.swing.JLabel imgGameMain;
    private javax.swing.JLabel imgMenuGame1;
    private javax.swing.JLabel imgMenuGame2;
    private javax.swing.JLabel imgMenuGame3;
    private javax.swing.JLabel imgMenuGame4;
    private javax.swing.JLabel imgMenuGame5;
    private javax.swing.JPanel infoUserGameInLibrary;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel jpanel99;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCashAfterPurchase;
    private javax.swing.JLabel lblCashBeforePurchase;
    private javax.swing.JLabel lblCashNeedToPurchase;
    private javax.swing.JLabel lblDevName;
    private javax.swing.JLabel lblGameName;
    private javax.swing.JLabel lblGameNameInReviewPost;
    private javax.swing.JLabel lblGameNameInStore1;
    private javax.swing.JLabel lblGameNameInStore2;
    private javax.swing.JLabel lblGameNameInStore3;
    private javax.swing.JLabel lblGameNameInStore4;
    private javax.swing.JLabel lblGameNameInStore5;
    private javax.swing.JLabel lblGameNameInTransaction;
    private javax.swing.JLabel lblGameNameWhenHover;
    private javax.swing.JLabel lblGameReleaseDateInReviewPost;
    private javax.swing.JLabel lblGameTag;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblImgDev;
    private javax.swing.JLabel lblImgGameInReviewPost;
    private javax.swing.JLabel lblOverralRating;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblPriceGame1;
    private javax.swing.JLabel lblPriceGame2;
    private javax.swing.JLabel lblPriceGame3;
    private javax.swing.JLabel lblPriceGame4;
    private javax.swing.JLabel lblPriceGame5;
    private javax.swing.JLabel lblPriceInTransaction;
    private javax.swing.JLabel lblReleaseDate1;
    private javax.swing.JLabel lblReleaseDate2;
    private javax.swing.JLabel lblReleaseDate3;
    private javax.swing.JLabel lblReleaseDate4;
    private javax.swing.JLabel lblReleaseDate5;
    private javax.swing.JLabel lblReleaseDateInTransaction;
    private javax.swing.JLabel lblReviewInStore;
    private javax.swing.JLabel lblTagGameInStore1;
    private javax.swing.JLabel lblTagGameInStore2;
    private javax.swing.JLabel lblTagGameInStore3;
    private javax.swing.JLabel lblTagGameInStore4;
    private javax.swing.JLabel lblTagGameInStore5;
    private javax.swing.JLabel lblTagInTransaction;
    private javax.swing.JLabel lblTotalReviews;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel panelChangeGame;
    private javax.swing.JPanel panelListGameDev;
    private javax.swing.JPanel panelPostReview;
    private javax.swing.JPanel panelReviewsInGame;
    private javax.swing.JPanel panelTransaction;
    private javax.swing.JScrollPane scrollPaneGamesGenre;
    private javax.swing.JScrollPane scrollPaneLibrary;
    private javax.swing.JScrollPane scrollPaneTransaction;
    private javax.swing.JScrollPane scrollPanelDevs;
    private javax.swing.JScrollPane scrollPanelGame;
    private javax.swing.JScrollPane scrollPanelReviewsGame;
    private javax.swing.JScrollPane scrollPanelStore;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtDeveloperInGameMenu;
    private javax.swing.JTextArea txtReview;
    private javax.swing.JTextField txtTag;
    // End of variables declaration//GEN-END:variables
};
