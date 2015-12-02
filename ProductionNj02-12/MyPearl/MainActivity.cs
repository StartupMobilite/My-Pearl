using System;
using System.Threading;
using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;

namespace MyPearl
{
    [Activity(Label = "MyPearl", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity
    {

        private Button BtnEnregistrer;
        private ProgressBar mProgressBar;


        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);
        
            BtnEnregistrer = FindViewById<Button>(Resource.Id.btnInscription);
            mProgressBar = FindViewById<ProgressBar>(Resource.Id.progressBar1);

            // syntaxe pour gagner de la place et fait directement la methode dedans
            BtnEnregistrer.Click += (object sender, EventArgs args) =>
            {
                FragmentTransaction transaction = FragmentManager.BeginTransaction();
                Fenetre_Inscription InscriptionFenetre = new Fenetre_Inscription();
                InscriptionFenetre.Show(transaction, "dialog fragment");

                InscriptionFenetre.mOnSignUpComplete += InscriptionFenetre_mOnSignUpComplete;
            };


        }

        private void InscriptionFenetre_mOnSignUpComplete(object sender, OnSignUpEventArgs e)
        {
            mProgressBar.Visibility = ViewStates.Visible;
            Thread thread = new Thread(ActLikeARequest);
            thread.Start();
            

        }

        private void ActLikeARequest()
        {
            Thread.Sleep(3000);

            RunOnUiThread(()=> {mProgressBar.Visibility = ViewStates.Invisible ; });
        }
    }
}

