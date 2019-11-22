/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Hrit
 */
public class PlayerGUI extends javax.swing.JFrame implements Runnable
{
    private int i = 0;
    private Player mp3File;
    private boolean isPaused;
    private long pauseLocation;
    private long startLocation;
    private InputStream fis;
    private boolean isStopped;
    private boolean repeat;
    private long songProgress;
    private double progressVal;
    private JFileChooser jf;
    private long PAUSE_ADJUSTMENT = 10000L;
    private ArrayList<String> queue;
    private String currentPath;
    private DefaultListModel model;
    private ImageIcon PLAY_ICON;
    private ImageIcon PAUSE_ICON;
    private ImageIcon STOP_ICON;
    private ImageIcon REPEAT_OFF;
    private ImageIcon REPEAT_ON;
    private Timer t;
    private double progressConst;
    private int timeInSeconds;
    private ArrayList<File> playLists;
    private JFileChooser fc_play;
    /**
     * Creates new form PlayerGUI
     */
    public PlayerGUI() {
        //playLists = new ArrayList<File>();
        timeInSeconds = 0; 
        PLAY_ICON = new ImageIcon(this.getClass().getResource("play.png"));
        PAUSE_ICON = new ImageIcon(this.getClass().getResource("pause.png"));
        STOP_ICON = new ImageIcon(this.getClass().getResource("stop.png"));
        REPEAT_OFF = new ImageIcon(this.getClass().getResource("repeatOff.png"));
        REPEAT_ON = new ImageIcon(this.getClass().getResource("repeatOn.png"));
        jf = new JFileChooser();
        //fc_play = new JFileChooser();
        model = new DefaultListModel();
        currentPath = null;
        queue = new ArrayList<String>();
        isStopped = true;
        pauseLocation = 0;
        fis = null;
        initComponents();
        queueList.setModel(model);
        this.setTitle("MP3 PLAYER");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Playlists = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        newPlaylistButton = new javax.swing.JButton();
        playlistsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        pathLabel = new javax.swing.JTextField();
        addMusicLabel = new javax.swing.JLabel();
        searchMusicLabel = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        songPath = new javax.swing.JTextField();
        displayIcon = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        queueScrollPane = new javax.swing.JScrollPane();
        queueList = new javax.swing.JList<>();
        queueText = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        stopLabel = new javax.swing.JLabel();
        repeatLabel = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        songProgressBar = new javax.swing.JProgressBar();
        deleteLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        playlistLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(204, 255, 0)));

        newPlaylistButton.setForeground(new java.awt.Color(0, 0, 255));
        newPlaylistButton.setText("Create new Playlist");

        playlistsLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        playlistsLabel.setForeground(new java.awt.Color(255, 51, 51));
        playlistsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playlistsLabel.setText("Playlists");

        jScrollPane1.setViewportView(jList1);

        addMusicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/add.png"))); // NOI18N

        searchMusicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/search.png"))); // NOI18N
        searchMusicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMusicLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(playlistsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newPlaylistButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchMusicLabel)
                            .addGap(18, 18, 18)
                            .addComponent(addMusicLabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(newPlaylistButton)
                        .addGap(18, 18, 18)
                        .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchMusicLabel)
                            .addComponent(addMusicLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(playlistsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout PlaylistsLayout = new javax.swing.GroupLayout(Playlists.getContentPane());
        Playlists.getContentPane().setLayout(PlaylistsLayout);
        PlaylistsLayout.setHorizontalGroup(
            PlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlaylistsLayout.setVerticalGroup(
            PlaylistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlaylistsLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 300));

        panel.setBackground(new java.awt.Color(255, 153, 0));
        panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));

        songPath.setFont(new java.awt.Font("Myanmar Text", 1, 12)); // NOI18N

        displayIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/headphones.png"))); // NOI18N

        titleText.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("MP3 Player ");

        queueList.setBackground(new java.awt.Color(0, 0, 0));
        queueList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
        queueList.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        queueList.setForeground(new java.awt.Color(255, 153, 0));
        queueScrollPane.setViewportView(queueList);

        queueText.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        queueText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        queueText.setText("QUEUE");

        statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/play.png"))); // NOI18N
        statusLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statusLabelMouseClicked(evt);
            }
        });

        stopLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/stop.png"))); // NOI18N
        stopLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopLabelMouseClicked(evt);
            }
        });

        repeatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/repeatOff.png"))); // NOI18N
        repeatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatLabelMouseClicked(evt);
            }
        });

        searchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/search.png"))); // NOI18N
        searchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLabelMouseClicked(evt);
            }
        });

        songProgressBar.setForeground(new java.awt.Color(0, 0, 0));

        deleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/delete.png"))); // NOI18N
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLabelMouseClicked(evt);
            }
        });

        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/add.png"))); // NOI18N
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelMouseClicked(evt);
            }
        });

        playlistLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/icons8-playlist-30.png"))); // NOI18N
        playlistLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(displayIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(songPath, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addLabel)
                            .addComponent(deleteLabel)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(statusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stopLabel)
                                .addGap(12, 12, 12)
                                .addComponent(repeatLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(playlistLabel))
                            .addComponent(songProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(queueScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(queueText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(displayIcon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(songPath, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(searchLabel))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stopLabel)
                                    .addComponent(statusLabel)
                                    .addComponent(repeatLabel))
                                .addGap(30, 30, 30))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(playlistLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(deleteLabel)
                        .addGap(27, 27, 27)
                        .addComponent(addLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(songProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(queueText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queueScrollPane))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statusLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusLabelMouseClicked
        if(jf.getSelectedFile() != null)
        {
            if(isPaused)
            {
                resume();
            }
            else if(isStopped)
            {
                //Overrides the existing queue data
                if(!queue.contains(jf.getSelectedFile().getPath()))
                {
                    queue = new ArrayList<String>();
                    model = new DefaultListModel();
                    queueList.setModel(model);
                    currentPath = jf.getSelectedFile().getPath();
                    queue.add(currentPath);
                    model.addElement(jf.getSelectedFile().getPath().substring(jf.getSelectedFile().getPath().lastIndexOf("\\") + 1).trim());
                }
                currentPath = queue.get(0);
                play(0);
            }
            else if(!isPaused && !isStopped)
            {
                pause();
            }
        }
    }//GEN-LAST:event_statusLabelMouseClicked

    private void stopLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopLabelMouseClicked
        stop();
    }//GEN-LAST:event_stopLabelMouseClicked

    private void repeatLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repeatLabelMouseClicked
        if(!repeat)
        {
            repeat = true;
            repeatLabel.setIcon(REPEAT_ON);
        }
        else
        {
            repeat = false;
            repeatLabel.setIcon(REPEAT_OFF);
        }
    }//GEN-LAST:event_repeatLabelMouseClicked

    private void searchLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchLabelMouseClicked
        int retVal = jf.showOpenDialog(this);
        if(jf.getSelectedFile() != null)
        {
            songPath.setText (jf.getSelectedFile().getName());
        }
    }//GEN-LAST:event_searchLabelMouseClicked

    private void deleteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseClicked
        if(queueList.getSelectedIndex() != -1)
        {
            if(queueList.getSelectedIndex() == 0)
            {
                stop();
            }
            queue.remove(queueList.getSelectedIndex());
            model.remove(queueList.getSelectedIndex());
        }
    }//GEN-LAST:event_deleteLabelMouseClicked

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMouseClicked
        if(jf.getSelectedFile() != null)
        {
            if(!queue.contains(jf.getSelectedFile().getPath()))
            {
                queue.add(jf.getSelectedFile().getPath());
                model.addElement(jf.getSelectedFile().getPath().substring(jf.getSelectedFile().getPath().lastIndexOf("\\") + 1).trim());
            }
        }
    }//GEN-LAST:event_addLabelMouseClicked

    private void playlistLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistLabelMouseClicked
        Playlists.pack();
        Playlists.setVisible(true);
    }//GEN-LAST:event_playlistLabelMouseClicked

    private void searchMusicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMusicLabelMouseClicked
        JFileChooser jfc = new JFileChooser("Search");
        int r = jfc.showOpenDialog(null);
        if(r == JFileChooser.APPROVE_OPTION)
        {
            pathLabel.setText(jfc.getSelectedFile().getName());
        }
    }//GEN-LAST:event_searchMusicLabelMouseClicked

    
    public void play(long position) 
    {
        statusLabel.setIcon(PAUSE_ICON);
        isStopped = false;
        if(position != 0)
        {
            position -= PAUSE_ADJUSTMENT;
        }
        try {
            fis = new FileInputStream(currentPath);
            startLocation = fis.available();
            progressConst = 100.0/startLocation;
            fis.skip(position);
            mp3File = new Player(fis);
        } catch (JavaLayerException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        updateProgressBar();
        Thread musicThread = new Thread(this);
        musicThread.start();
    }
    
    public void pause()
    {
        t.stop();
        statusLabel.setIcon(PLAY_ICON);
        isPaused = true;
        if(mp3File != null)
        {
            try 
            {
                pauseLocation = fis.available();
                mp3File.close();
            } 
            catch (IOException ex) 
            {
               ex.printStackTrace();
            }
        }
    }
    
    public void resume()
    {
        play(startLocation - pauseLocation);
        isPaused = false;
        pauseLocation = 0;
    }
    
    public void stop()
    {
        t.stop();
        queue.remove(0);
        model.remove(0);
        songProgressBar.setValue(0);
        timeInSeconds = 0;
        songProgressBar.setString("00:00");
        statusLabel.setIcon(PLAY_ICON);
        isStopped = true;
        isPaused = false;
        if(mp3File != null)
            mp3File.close();
        pauseLocation = 0;
    }
    
    
    
    @Override
    public void run()
    {
        try {
            mp3File.play();
            if(!isPaused && mp3File.isComplete())
            {
                t.stop();
                isStopped = true;
                songProgressBar.setValue(0);
                timeInSeconds = 0;
                songProgressBar.setString("00:00");
                if(repeat)
                    play(0);
                else if(!queue.isEmpty())
                {
                    queue.remove(0);
                    model.remove(0);
                    if(!queue.isEmpty())
                    {
                        currentPath = queue.get(0);
                        play(0);
                    }
                    else
                    {
                        statusLabel.setIcon(PLAY_ICON);
                    }
                }
            }
        } catch (JavaLayerException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateProgressBar()
    {
        t = new Timer(1000,new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    i = (int)(progressConst*(startLocation - fis.available()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                timeInSeconds++;
                songProgressBar.setValue(i);
                if(timeInSeconds % 60 < 10)
                {
                    songProgressBar.setString("0" + timeInSeconds/60 + ":0" + timeInSeconds%60);
                }
                else
                {
                    songProgressBar.setString("0" + timeInSeconds/60 + ":" + timeInSeconds%60);
                }
                songProgressBar.setStringPainted(true);
            }
        });
        t.start();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               PlayerGUI ob =  new PlayerGUI();
               ob.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Playlists;
    private javax.swing.JLabel addLabel;
    private javax.swing.JLabel addMusicLabel;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel displayIcon;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newPlaylistButton;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField pathLabel;
    private javax.swing.JLabel playlistLabel;
    private javax.swing.JLabel playlistsLabel;
    private javax.swing.JList<String> queueList;
    private javax.swing.JScrollPane queueScrollPane;
    private javax.swing.JLabel queueText;
    private javax.swing.JLabel repeatLabel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel searchMusicLabel;
    private javax.swing.JTextField songPath;
    private javax.swing.JProgressBar songProgressBar;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel stopLabel;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables

}
